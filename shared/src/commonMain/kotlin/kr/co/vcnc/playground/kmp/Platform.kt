package kr.co.vcnc.playground.kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform