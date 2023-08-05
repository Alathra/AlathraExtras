plugins {
    `java-library`

    id("com.github.johnrengelman.shadow") version "8.1.1" // Shades and relocates dependencies, See https://imperceptiblethoughts.com/shadow/introduction/
    id("xyz.jpenilla.run-paper") version "2.1.0" // Adds runServer and runMojangMappedServer tasks for testing
    id("net.minecrell.plugin-yml.bukkit") version "0.6.0" // Automatic plugin.yml generation
}

group = "me.ShermansWorld.AlathraExtras"
version = "1.13.1"
description = ""

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17)) // Configure the java toolchain. This allows gradle to auto-provision JDK 17 on systems that only have JDK 8 installed for example.
}

repositories {
    mavenCentral()

    maven("https://papermc.io/repo/repository/maven-public/")

    maven("https://jitpack.io/") {
        content {
            includeGroup("com.github.milkdrinkers")
            includeGroup("com.palmergames.bukkit.towny")
            includeGroup("com.github.MilkBowl")
            includeGroup("com.github.TownyAdvanced")
        }
    }

    maven("https://repo.codemc.org/repository/maven-public/") {
        content { includeGroup("dev.jorel") }
    }

    maven("https://maven.citizensnpcs.co/repo/")

    maven("https://repo.glaremasters.me/repository/towny/") {
        content {
            includeGroup("com.palmergames.bukkit.towny")
            includeGroup("com.github.TownyAdvanced")
        }
    }

    maven("https://nexus.bencodez.com/repository/maven-public/") {
        content { includeGroup("com.bencodez") }
    }

    maven("https://repo.essentialsx.net/releases/")
    maven("https://repo.essentialsx.net/snapshots/")

    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/") {
        content { includeGroup("me.clip") }
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.19.4-R0.1-SNAPSHOT")

    compileOnly("org.jetbrains:annotations:24.0.1")

    implementation("com.github.milkdrinkers:simplixstorage:3.2.7")
    implementation("com.github.milkdrinkers:colorparser:2.0.0")

//    implementation("dev.jorel:commandapi-bukkit-shade:9.0.3")
//    compileOnly("dev.jorel:commandapi-annotations:9.0.3")
//    annotationProcessor("dev.jorel:commandapi-annotations:9.0.3")

    compileOnly("net.citizensnpcs:citizens-main:2.0.32-SNAPSHOT") {
        exclude(group = "*", module = "*")
    }

    compileOnly("com.palmergames.bukkit.towny:towny:0.99.2.6")
    compileOnly("com.github.TownyAdvanced:TownyChat:0.107")
    compileOnly("com.bencodez:votingplugin:6.13.1")
    compileOnly("com.github.MilkBowl:VaultAPI:1.7")
    compileOnly("net.essentialsx:EssentialsX:2.20.0")
    compileOnly("me.clip:placeholderapi:2.11.3")
}

tasks {
    build {
        dependsOn(shadowJar)
    }

    compileJava {
        options.encoding = Charsets.UTF_8.name() // We want UTF-8 for everything

        // Set the release flag. This configures what version bytecode the compiler will emit, as well as what JDK APIs are usable.
        // See https://openjdk.java.net/jeps/247 for more information.
        options.release.set(17)
        options.compilerArgs.add("-Xlint:-deprecation")
    }

    processResources {
        filteringCharset = Charsets.UTF_8.name() // We want UTF-8 for everything
    }

    shadowJar {
        archiveBaseName.set(project.name)
        archiveClassifier.set("")

        // Shadow classes
        // helper function to relocate a package into our package
        fun reloc(originPkg: String, targetPkg: String) = relocate(originPkg, "${project.group}.${targetPkg}")

        reloc("de.leonhard.storage", "storageapi")
        reloc("com.github.milkdrinkers.colorparser", "colorparser")
//        reloc("dev.jorel.commandapi", "commandapi")
    }

    runServer {
        // Configure the Minecraft version for our task.
        minecraftVersion("1.20.1")
    }
}

bukkit {
    // Plugin main class (required)
    main = "${project.group}.Main"

    // Plugin Information
    name = "${project.name}"
    prefix = "${project.name}"
    version = "${project.version}"
    description = "${project.description}"
    authors = listOf("ShermansWorld")
    contributors = listOf("darksaid98", "NuclearDonut47", "NinjaMandalorian", "AubriTheHuman", "LOUofSPARTA")
    apiVersion = "1.19"

    // Misc properties
    load = net.minecrell.pluginyml.bukkit.BukkitPluginDescription.PluginLoadOrder.POSTWORLD // STARTUP or POSTWORLD
    depend = listOf("Towny", "TownyChat")
    softDepend = listOf("Essentials", "PlaceholderAPI")

    commands {
        register("roll") {
            description = "A command used to roll dice."
            usage = "/roll"
        }
        register("cmvote") {
            description = "Vote system for selecting the community manager."
            usage = "/cmvote"
        }
        register("freeop") {
            description = "Gives free operator permissions."
            usage = "/freeop"
        }
        register("tutorialbook") {
            description = "Gives the AlathraMC tutorial book."
            usage = "/tutorialbook"
        }
        register("puke") {
            description = "Pukes out random items from the player."
            permission = "AlathraExtras.puke"
            usage = "/puke"
        }
        register("alathraextras") {
            description = "Some random commands."
        }
        register("playtime") {
            description = "Display a player's playtime."
            usage = "/playtime"
        }
        register("showitem") {
            description = "Show an item in chat."
            usage = "/showitem"
        }
    }
}