# TrafficLights

@ Route Class: each Route object stands for one direction, 12 objects in total. 
	-- In each Route, new moto are randomly added to and stored at the collection. 
	-- Each Route will check the light every two seconds. If the lights is G, then remove the very first moto in the collection.
	-- Every two seconds, each Route will check whether its light is G. If one G light turns to R, the light of next Route has to turn G.

	-- 12 Routes in total. 4 right-turn lights are keeping G. The other 8 lights are grouped into 4 pairs. 
	-- The 4 pairs of lights will turn G in a cycle round. In the Light Class, we need to mark the light of the opposite direction, as well as the next direction.
	-- Cause the light of each direction has only one object in the whole system, the Light Class is better to be enum
	
  In each Route, we have name(direction), motos(vehicles storage collection). In the construction method, create one thread to add one new moto to the collection every random interval.
  We also create a thread of timer to check whether the light of current Route is G. If YES, then remove the first one from the collection.
  