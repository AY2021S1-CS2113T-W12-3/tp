# WatchNext Developer Guide


* [1. Introduction](#1-introduction)
    + [1.a Purpose](#1a-purpose)
    + [1.b Scope](#1b-scope)
* [2. Setting up](#2-setting-up)
    + [2.a Prerequisites](#2a-prerequisites)
    + [2.b Setting up project](#2b-setting-up-the-project-in-your-computer)
    + [2.c Verifying the setup](#2c-verifying-the-setup)
    + [2.d Before Writing Code](#1)
* [3. Design](#3-design)
* [4. Implementation](#4-implementation)
- [5. Documentation](#5-documentation)   
- [6. Testing](#6-testing)   
- [7. Dev Ops](#7-dev-ops)  
- [Appendices](#user-stories)  
   
## 1. Introduction

### 1.a Purpose

This guide aims to provide information for you: the developers, testers and future contributors of **WatchNext** 
such that you will have an easy reference for understanding the features implemented in **WatchNext**.


### 1.b Scope

The guide outlines the architecture and design decisions for the implementation of WatchNext.The intended audience of this 
document are the developers, testers and future contributors of WatchNext.
   

## 2. Setting up
This section will show you the requirements that you need to fulfill in order to quickly start contributing to this project in no time!

### 2.a Prerequisites

1. **JDK `11`**  

[NOTE]
The `WatchNext.jar` file is compiled using the Java version mentioned above. +

2. **IntelliJ IDEA** IDE

[NOTE]
IntelliJ has Gradle and JavaFx plugins installed by default.
Do not disable them. If you have disabled them, go to `File` > `Settings` > `Plugins` to re-enable them.

### 2.b Setting up the project in your computer
 
 **Fork** this [repo](https://github.com/AY2021S1-CS2113T-W12-3/tp), and clone the fork to your computer.
 
1. Open IntelliJ (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project dialog first)

2. You should set up the correct JDK version for Gradle

3. Click `Configure` > `Project Defaults` > `Project Structure`

4. Click `New...` and find the directory of the JDK

5. Click `Import Project`

6. Locate the `build.gradle` file and select it. Click `OK`

7. Click `Open as Project`

8. Click `OK` to accept the default settings

9. Open a console and run the command `gradlew processResources` (Mac/Linux: `./gradlew processResources`). It should finish with the `BUILD SUCCESSFUL` message. +
This will generate all the resources required by the application and tests.

### 2.c Verifying the setup

1. You can run `Duke` and try a few commands.

2. You can also run tests using our instructions for manual testing to explore our features.

### 2.d Before Writing Code
 
 1. Set up CI
 
 This project comes with a GitHub Actions config files (in `.github/workflows` folder). When GitHub detects those files, it will run the CI for your project automatically at each push to the master branch or to any PR. No set up required.
 
 2. Learn the design
 
 When you are ready to start coding, we recommend that you get some sense of the overall design by reading about WatchNext’s architecture [here](#3-design).

## 3. Design
WatchNext was designed drawing from the ideas of the __Event-driven architectural style__. <br>
<br>The Ui and the Scanner components work together as event emitters. The `Ui` class prompts the user for input, and the scanner is ready to receive the input. Should the format of the input be unrecognised or incorrect, the `Ui` class guides the user with prompts to rectify the errors.<br>
<br>Events will be passed onto the `InputParser` which serves as the dispatcher. The `InputParser` uses various string manipulation operations from the `StringOperations` class to recognise the intention of the user input. After recognising the command, the input will be parsed, and the command information will be passed onto the various command classes for processing. The `InputParser` communicates the events to event consumers which are the command classes in this case. <br>
<br>All available operations will be processed by the classes in the commands package. Every command class, like the `AddCommand` class, inherits from the `Command` class. Each individual command class is able to contain all the processing required for each command with the inputs passed in during the initiation of each command object. <br>
<br>During runtime, the show related data is all stored in the `ShowList` class. The data is accessible and can be modified statically by all the command classes. The `ShowList` contains `Show` objects which describes the attributes of a show. 
<br>Certain commands relating to the monitoring of the amount of time users spend watching shows depend on information from the `WatchTime` class. The class tracks the date and time remaining for the users to watch shows for the day. The time limit will be set by the user. <br>
<br>On the initiation of WatchNext, the `Storage` object will be initiated and retrieves any user data that has been saved from previous runs. The data is stored in plain text and can be manually edited by advanced users. The data is stored in `data/showList.txt`. After the execution of every command, the `Storage` object calls upon the save command to automatically update the save data file. The commands relating to saving and loading data can be accessed from the `SaveState` interface.<br>
<br>Throughout the lifespan of the program, various errors may occur. The `ErrorHandling` class stores the various errors that could occur. The expected errors usually stem from invalid user input or Input Output (IO) errors during file loading. The `Ui` class informs the users of the errors detected and suggests actions for rectification. <br>

## 4. Implementation
## 5. Documentation
## 6. Testing
Two main forms of testing was used for the development of **WatchNext**. 
1. Text-ui-test
    1. This seeks to test the general flow of the program and simulates the "expected" or "smooth" lifespan of the program.
    2. This is useful to ensure that the changes to one class does not inadvertently affect the operation of another. Any changes to the operation of another class will show through this test and can be rectified by the developer.
    3. Text-ui-test is also a good final litmus test on the smooth running of the program before it is released to production. 
2. J-unit
    1. The test mainly focuses on the correctness of each individual class.
    2. This tests the functions within each class and ensures that it behaves as expected by testing the output of each function against what is expected.
    3. The benefits include ensuring that the coupling between the classes do not cause any unexpected behaviour when another class has been modified.
    4. The errors thrown from the J-unit tests allow the developer to zoom in on the classes which are not showing the expected behaviour to quickly and effectively rectify the bugs.
## 7. Dev Ops
##  Appendices


### Target user profile

**WatchNext** is a program made for teenagers and young adults.For users who use multiple free streaming platforms or other open source stream websites,
the application will track their progress in the different shows they watch, and the upcoming shows they wish to watch.In addition, it provides a tracker 
to limit your weekly show progress to help manage your time.

**WatchNext** is optimized for users who prefer to work with the Command Line Interface (CLI).

### Value proposition

There exists many options for streaming all sorts of video content from the giant media service provider company netflix, to other platforms that lean
towards user sourced content.<br><br> This poses a new challenge to any tech-savvy person who wants to make sure they do not miss a single episode of their 
favourite show. Netflix and other established streaming platforms are able to keep track of the user's progress, but should be the user use more than one
streaming platform, there is no avenue of communication between the streaming platforms to synchronise this data.<br><br> **WatchNext** seeks to fill in this gap 
by providing users with a single streamlined platform to keep track of the episodes of all their favourite shows. They do not need to worry about re-watching
or missing episodes with the help of **WatchNext's** show progress tracking features. <br>
<br>**WatchNext** also helps users track the total time they spend watching shows across all platforms. This provides users with an encompassing view of the
actual time they spend watching shows and is a feature that is not provided by most other platforms.


## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v2.0|new user|limit my watching time sometimes|I do not get carried away and watch too many shows in one sitting|
|v1.0|user|be able to share my watch history |I can export and share the shows that I like with my friends.|
|v1.0|show enthusiast|revisit my ratings for shows i have watched|change the rating in the event that i want to.|
|v1.0|show enthusiast|know which current episode i am at|continue watching the show later.|
|v1.0|student|track my watchtime|not miss my deadlines.|
|v1.0|show enthusiast|revisit my ratings for shows i have watched|change the rating in the event that i want to.|
|v1.0|user|clear my watch history |I can protect my privacy.|
|v1.0|student|I want to track which zoom lectures / or webcasts that I have watched| I can make sure I don’t miss any important lessons.|


## Non-Functional Requirements

1. WatchNext will work on any mainstream OS as long as it has Java 11 installed.

2. Users who can type fast and prefer typing over other means of input should be able to use WatchNext faster using commands than using the mouse in a GUI(Graphic User Interface)-based program.

## Glossary

* *Graphic User Interface* - It is a user interface that includes graphical elements, such as windows, icons and buttons.

## Instructions for manual testing

**[NOTE]** The instructions and sample test cases only act as a guide for you to start testing on some of our application features. You are free to test our features with more test cases of your own. Refer to [Section 2.a,“Prerequisites”](#2a-prerequisites) for the instructions to set up our program on your computer.

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
