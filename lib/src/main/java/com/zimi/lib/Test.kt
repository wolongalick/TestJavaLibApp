package com.zimi.lib

class Test {
    companion object {
        /** 我是main入口函数 **/
        @JvmStatic
        fun main(args: Array<String>) {
            val list = arrayListOf("1", "2", "3", "4", "5")
            val list2 = arrayListOf("A", "B", "C", "D", "E")

            println("==================kotlin中的continue用法==================")
            println("在for中")
            for (s in list) {
                if (s == "3") {
                    continue
                }
                println(s)
            }

            println("在forEach中")
            list.forEach { s ->
                if (s == "3") {
                    return@forEach
                }
                println(s)
            }

            println("在forEach中(自定义标签:continuing)")
            list.forEach continuing@{ s ->
                if (s == "3") {
                    return@continuing
                }
                println(s)
            }

            println("在forEachIndexed中")
            list.forEachIndexed { index, s ->
                if (s == "3") {
                    return@forEachIndexed
                }
                println(s)
            }

            println("==================kotlin中的break用==================")
            println("在for中")
            for (s in list) {
                if (s == "3") {
                    break
                }
                println(s)
            }

            println("在双层for中-跳出内层循环")
            for (s2 in list2) {
                for (s in list) {
                    if (s == "3") {
                        break
                    }
                    println(s)
                }
                println(s2)
            }

            println("在双层for中-跳出外层循环(自定义标签:breaking)")
            breaking@ for (s2 in list2) {
                for (s in list) {
                    if (s == "3") {
                        break@breaking
                    }
                    println(s)
                }
                println(s2)
            }

            println("在forEach中果(自定义标签:breaking)")
            run breaking@{
                list.forEach { s ->
                    if (s == "3") {
                        return@breaking
                    }
                    println(s)
                }
            }
            println("==================演示结束==================")
        }
    }
}