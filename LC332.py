from collections import defaultdict, deque
from typing import List
import heapq

class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        source_to_destinations = defaultdict(list)
        
        for source, destination in tickets:
            heapq.heappush(source_to_destinations[source], destination)
        
        itinerary = deque()
        
        def buildItinerary(source):
            while source_to_destinations[source]:
                buildItinerary(heapq.heappop(source_to_destinations[source]))

            itinerary.appendleft(source)
        
        buildItinerary('JFK')

        return list(itinerary)
