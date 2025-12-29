# Startnewlife Android

## 环境要求
- JDK 17（建议 Temurin 17）
- Android SDK（建议至少安装 `platforms;android-34`、`build-tools;34.0.0`、`platform-tools`）
- Android Studio 建议版本：Jellyfish 2023.3.1 或更新（如课程/团队文档有更明确要求，以文档为准）

## 一键复现（与 CI 一致）
```bash
./gradlew ktlintCheck detekt testDebugUnitTest lintDebug assembleDebug
```

Windows 可用：
```bat
gradlew.bat ktlintCheck detekt testDebugUnitTest lintDebug assembleDebug
```

## CI 说明
- Workflow：`.github/workflows/android.yml`
- CI 不依赖 `local.properties`，通过 `ANDROID_SDK_ROOT`/`ANDROID_HOME` 获取 SDK 位置

## 常见问题
1) 找不到 Android SDK
   - 方式 A：设置环境变量 `ANDROID_SDK_ROOT`（或 `ANDROID_HOME`）
   - 方式 B：创建本机 `local.properties`（仅本地，不提交）：
     ```
     sdk.dir=/path/to/Android/Sdk
     ```
2) Gradle Wrapper 下载失败或损坏
   - 删除 `~/.gradle/wrapper/dists` 后重试
   - 或重建 wrapper：`./gradlew wrapper --gradle-version 8.6 --distribution-type bin`
3) 缺少 SDK 平台或 Build Tools
   - 使用 Android Studio 的 SDK Manager 安装
   - 或命令行安装：`sdkmanager "platforms;android-34" "build-tools;34.0.0"`
4) JDK 版本不匹配
   - 确保 `JAVA_HOME` 指向 JDK 17，并在终端执行 `java -version` 校验
