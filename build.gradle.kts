plugins {
	kotlin("jvm") version "1.3.11"
}

group = "io.github.snarks"
version = "0.1-DEV"

repositories {
	mavenCentral()
}

dependencies {
	compileOnly(kotlin("stdlib"))
	testImplementation(kotlin("test-junit5"))
}
