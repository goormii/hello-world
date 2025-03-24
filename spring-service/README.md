# /spring-service

## 1. multi-module project
How to avoid trouble (not best practice)

### 1.1. How to init project
Create empty gradle project.

### 1.2. How to add module
Add module in any format you'd like.
- each module must contain `build.gradle`.

Keep the same folder structure in all modules:
- `src/main/java/org/example/MODULE_NAME/.../Foo.java`

### 1.3. How to import common module
Edit `build.gradle`:
```groovy
dependencies {
    // ...
    
    // When target module is 'lib'
    implementation project(':lib')
}
```

### 1.4. How to build
`gradle build`

#### 1.4.1. `... does not provide the required capabilities: [JAVA_COMPILER]`
Error message:
```
$ gradle build                                                                                                                           [23:32:30]

FAILURE: Build failed with an exception.

* What went wrong:
Could not determine the dependencies of task ':compileJava'.
> Could not resolve all dependencies for configuration ':compileClasspath'.
   > Failed to calculate the value of task ':compileJava' property 'javaCompiler'.
      > Toolchain installation '/usr/lib64/jvm/java-21-openjdk-21' does not provide the required capabilities: [JAVA_COMPILER]

```

Check your toolchain
```
$ gradle javaToolchains                                                                                                                  [23:36:39]

> Task :javaToolchains

 + Options
     | Auto-detection:     Enabled
     | Auto-download:      Enabled

 + Eclipse Temurin JDK 21.0.6+7-LTS
     | Location:           /home/msisdev/.jdks/temurin-21.0.6
     | Language Version:   21
     | Vendor:             Eclipse Temurin
     | Architecture:       amd64
     | Is JDK:             true
     | Detected by:        IntelliJ

 + N/A JRE 21.0.6+7-suse-1.3-x8664
     | Location:           /usr/lib64/jvm/java-21-openjdk-21
     | Language Version:   21
     | Vendor:             N/A
     | Architecture:       amd64
     | Is JDK:             false
     | Detected by:        Current JVM
```

Select toolchain
```
$ export JAVA_HOME=/home/msisdev/.jdks/temurin-21.0.6 
```

