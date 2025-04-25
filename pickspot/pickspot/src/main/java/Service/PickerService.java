package Service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import Model.Container;
import Model.Slot;

// PickerService class handles the logic for selecting the best slot for a container
@Service
public class PickerService {

    // constant value used to represent invalid or unsuitable options
    private static final int INVALID = 10_000;

    // this method chooses the best slot for a given container.
    public Optional<Slot> chooseBestSlot(Container c, List<Slot> slots) {
        Slot best = null; // it will store the best slot found
        int bestScore = INVALID + 1; // the initial score is set to an invalid value

        // loop through all available slots and calculate a score for each slot
        for (Slot s : slots) {
            int score = score(c, s); // calculate the score for the current slot
            // if the score is better (lower), update the best slot and score
            if (score < bestScore) {
                bestScore = score;
                best = s;
            }
        }
        // if no suitable slot is found it return an empty Optional; otherwise, return the best slot
        return bestScore >= INVALID ? Optional.empty() : Optional.of(best);
    }

    // this method calculates the score for a slot based on various factors:
    // - distance between the container and the slot
    // - whether the slot can accommodate the container size
    // - whether the slot supports cold storage if needed by the container
    // - whether the slot is occupied
    private int score(Container c, Slot s) {
        // calculate the Manhattan distance (horizontal + vertical) between the container and the slot
        int distance = Math.abs(c.getX() - s.getX()) + Math.abs(c.getY() - s.getY());
        
        // penalty for size mismatch: if the container is big and the slot is small, it's invalid
        int sizePenalty = (c.getSize().equals("big") && s.getSizeCap().equals("small")) ? INVALID : 0;

        // penalty for cold unit mismatch: if the container needs cold storage but the slot doesn't have it
        int coldPenalty = (c.isNeedsCold() && !s.isHasColdUnit()) ? INVALID : 0;

        // penalty for occupied slot: if the slot is already taken its invalid
        int occPenalty = s.isOccupied() ? INVALID : 0;

        // the total score is the sum of these penalties and distance
        // the lower the score, the better the slot for the container
        return distance + sizePenalty + coldPenalty + occPenalty;
    }
}
