# Java Map Interface
- A map contains values on the basis of **key and value pair**.
- Each key and value pair knowns as an **entry**
- A map contains **unique** keys

## Java Map Hierarchy
- Two interfaces: Map and SortedMap
- Three clasess: HashMap, LinkedHashMap and TreeMap

## Features:
- Doesn't allow duplicate keys, but can have duplicate values
- HashMap and LinkedHashMap allow null keys and values but not TreeMap
- Map can't be traversed (brainfucked), need to convert into Set using keySet() or entrySet() method

