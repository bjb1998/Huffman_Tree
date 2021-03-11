a. I'd say in total this was roughly 8 - 12 hours of work, counting googling, reading powerpoint, etc.

b. The implementation of ArrayHeap with <T>, T has no set comapreTo method or comparators so
this by itself was relatively difficult until I cast it as a comaprable.
 i. I consulted StackOverflow, and related websites, There was no good answer until I found out that <T> can
    be cast as a comparabale. From then on, implementation was rather trivial.

c. Replicating the steps shown from the powerpoint to actual code. I made method to follow the steps
(almost) exactly step by step with "Eerie eyes seen near lake." from the powerpoint. The only differnece
was the use of an ArrayHeap vs a LinkedList, the results came compressed as per a regular Huffman Tree. 
Also tested with other sentences such as "eeyjjjj", and "she sells seashells by the seashore."

d. Have the ArrayHeap use NuffmanNode<T> by itself rather than having just T right from the start.
Attempting to implement T with an ArrayNode proved to be too difficult, as T has no compareTo
by itself. However, doing this gets one into the good habit of code reusability.

e. The purpose of this assignment was to find a practical application of ArrayHeap's and
Queue's working together. Learning one individually is fine, as is their individual applications.
However, seeing them being both used at the same time helps one see the uses in uses beyond trivial
applications we were previously taught.