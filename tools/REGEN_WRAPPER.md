# Regenerate Gradle Wrapper (8.6)

This repo requires a valid `gradle-wrapper.jar` that contains
`org/gradle/wrapper/GradleWrapperMain.class`.

## Prerequisites
- A local Gradle installation available as `gradle` on PATH.

## Steps
1. From the repo root, run:
   ```
   gradle wrapper --gradle-version 8.6 --distribution-type bin
   ```
2. Verify the wrapper jar contains `GradleWrapperMain`:
   - JDK available:
     ```
     jar tf gradle/wrapper/gradle-wrapper.jar | findstr GradleWrapperMain
     ```
   - Or with Python:
     ```
     python -m zipfile -l gradle/wrapper/gradle-wrapper.jar
     ```
     (Look for `org/gradle/wrapper/GradleWrapperMain.class`.)
3. Commit the updated files:
   - `gradle/wrapper/gradle-wrapper.jar`
   - `gradle/wrapper/gradle-wrapper.properties`

