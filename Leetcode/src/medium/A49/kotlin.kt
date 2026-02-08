package medium.A49

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val map: MutableMap<String, MutableList<String>> = HashMap()
    for (str in strs) {
        val key = str.toCharArray().sorted().toString()
        val list = map.getOrDefault(key = key, defaultValue = mutableListOf())
        list.add(str)
        map[key] = list
    }
    return ArrayList(map.values)
}
