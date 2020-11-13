# Chen Jiqing - Project Portfolio Page for WatchNext

# Overview
**WatchNext** is a show tracker designed for users who watch their favourite shows on multiple free streaming platforms and other open source streaming websites.
**WatchNext** records your progress for the different shows you are currently watching, and even for upcoming shows that you plan to watch.

## Summary of Contributions

* **Feature**: Added the ability to store information into the file and load information from the file.
    * What it does: Allows **WatchNext** to store the watchlist and the watch time information to a local file. It also allows **WatchNext** to load these information from the local file.
    * Justification: This feature improves the product significant as user can store their watchlist in their computer.
    * Highlight: This feature is relevant to the core data of **WatchNext** so it is truly important. The feature also need to be updated frequently because as new functions are implemented, the data format also changes.

### Enhancements implemented:
* Implement Storage feature: This feature allows **WatchNext** to load information from a file and save current information to a file automatically.
      
* Implement `Search` command: this command allows users to search a show in the shows list and get the detailed information.  
    
* Add exceptions for `Season` command.
    
* Implement test case for Storage feature.   
    
    
### Contribution to documentation:

* For User Guide:
     * Add documentation for the commands `delete`, `Season`, `Episode` and `search`.  
        
     * Add documentation for Q&A.  
        
     * Update documentation when some command formats are changed.  
        
* For Developer Guide:
    
     * Add implementation detail of storage feature.
        
     * Make the UML class diagrams of overall and storage, the sequence diagrams of overall, the flow diagram of edit command with teammate [Jazhten](https://github.com/jazhten).
        
     * Make the UML sequence diagram of storage feature.
        
### Contribution to team-based tasks:

* Release **WatchNext** V2.0.
    
* Make class diagram and sequences diagram of architecture level with teammate [Jazhten](https://github.com/jazhten)
    
### Review/mentoring contributions:
* Detect and fix bugs [#199](https://github.com/AY2021S1-CS2113T-W12-3/tp/issues/199) [#160](https://github.com/AY2021S1-CS2113T-W12-3/tp/issues/160) 
