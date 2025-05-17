# RTB Core Library
---  

This is a core library for RTB. Will primarily be maintained for all entities.
Can also be used for common functionalities to be used across different servicces.


## Steps to build and publish 
1. Build this project locally `./gradlew clean build`
2. Publish the artifact to your local m2 repository `./gradlew clean publish`
3. Verify if the core library is available in your local .m2 repository.

## Steps to use the library in other services
1. Include the package in your `build.gradle` file under the dependencies section as - `implementation "com.rtb.core:core:0.0.1"`
2. Ensure you have the right version mentioned.
3. Rebuild your service, and you should be able to access the artifact.

--- 
