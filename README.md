# PotA Offhand Guard

A lightweight Fabric 1.20.1 compatibility fix developed for **Path of the Ascended**.

Protects offhand items from disappearing when casting RMB-bound Spell Engine spells with Better Combat two-handed weapons. The mod is intended to preserve shields, grappling hooks, blocks and other offhand items while leaving spellcasting and ordinary interactions available as they were in the tested PotA configuration.

No additional configuration, gameplay mechanics, or user interface is added.

## Requirements

- Minecraft **1.20.1**, **Fabric**, Java **17**
- **Better Combat** (tested with 1.8.6)
- **Spell Engine** (tested with 0.15.12)

## How it works

The mod guards certain offhand actions when Better Combat identifies a two-handed main-hand weapon, the inventory offhand still contains an item, and the equipped offhand appears empty. It intercepts client and server item interactions and prevents an inappropriate offhand clear in that state.

This repository contains **version 1.0.0.1**, updated from the recovered and bytecode-verified 1.0.0 production source. The only code change is removal of repeated console logging; the offhand checks and Mixin behaviour are unchanged. A regression test in the current modpack is recommended before replacing the previously tested release.

## Building

Use Java 17 and Gradle 8.8:

```sh
gradle clean build
```

The build resolves Better Combat 1.8.6 through CurseMaven. No third-party JARs are checked into this repository. Built artifacts appear in `build/libs/`.

## License

**Copyright © 2026 Path of the Ascended. All Rights Reserved.**

This is publicly visible source, **not an open-source licence**. See [LICENSE](LICENSE) for terms. Any rights granted under earlier MIT-licensed distributions remain in effect.

## AI-Assisted Development Disclosure

This mod was written with the assistance of AI. All code has been reviewed, tested, and refined by a human developer to ensure functionality, compatibility, and performance.
