This project is a simple API that helps decide where to place containers in a yard, based on a few mathematical rules (formulas). the idea is to make container movements more efficient by calculating the best slots using given data.

# What This Does
Accepts a list of formulas and container info (like position, weight, urgency).
Calculates the best place (yard slot) to move each container.
Returns a list of optimized moves with scores.

# Tech Used
Java 17 with Spring Boot
Maven for project management
REST API (HTTP endpoint)

# Example Request
You send a request in josin formate like this to the API-
{
  "formulas": [
    "distance = sqrt((x2 - x1)^2 + (y2 - y1)^2)",
    "cost = weight * distance",
    "priority = cost / urgencyFactor"
  ],
  "containerData": [
    { "id": "C001", "x": 1, "y": 2, "weight": 100, "urgencyFactor": 3 },
    { "id": "C002", "x": 3, "y": 4, "weight": 120, "urgencyFactor": 2 }
  ]
}
And the API responds with something like-
{
  "optimizedPlan": [
    {
      "containerId": "C002",
      "targetSlot": "Yard-7",
      "score": 42.67
    },
    {
      "containerId": "C001",
      "targetSlot": "Yard-3",
      "score": 38.25
    }
  ]
}
# Performance
Average response time: around 55ms
Tested with: Postman (10 quick requests in a row)
Test machine: 8GB RAM, Intel i5

# Note for Reviewers
# This project was created as part of an interview assignment. its not meant to be reused or distributed publicly.
