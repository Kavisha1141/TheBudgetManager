# My Personal Project: The Budget Manager

## User-friendly tool designed to help manage budget and finances!

The goal of the project is to create a simple budget manager for students to 
keep track of their finances. In the world we live in today, finances play a
**HUGE ROLE**, especially for students learning to be financially independent.
College students are exposed to new responsibilities such as buying groceries,
paying bills, rent, *STUDENT LOANS* and balancing their wants with their needs.  
Learning all of this, on their own, can be difficult.

In this learning process, technology can be a powerful tool. Because of this reason,
I came up with Budget Manager. Through Budget Manager, students can keep track of their income, 
expenses, and saving goals.  

*💻 Tech Stack / Technologies Used:*
- Java – Core programming language used for logic and application flow
- Swing (Java Swing) – GUI framework used for building the desktop user interface
- JSON – Used for storing and reading user data (expenses, categories, etc.)

*The Budget Manager* User Stories:
- I want to be able to add my **income, expenses and savings**
- I want to be able to set a **target amount** for my **savings** 
- I want to be able to view my money spend in total, my savings in total, and my income left
- I want to be able to view a user report of all expenses, earnings, savings and balance
- I want to be able to save my account info into a file
- I want to be able to reload previously saved account info from my accounts


*Instructions for end user*:
- You can generate the first required action related to the user story "adding multiple Xs to a Y" by pressing the button "Add an expense"/"Add an earning" in the earnings/expenses tab
- You can generate the second required action using "Update info" button in dashboard which shows total expenses/earnings and remaining balance
- You can generate the third required action related to the user story "viewing Xs in Y" by going into the expense/earnings tab and pressing "update earnings report" and "update expenses report" button.
- You can locate my visual component by the splashscreen before the app launches and the progress bar in the dashboard
- You can save the state of my application by pressing the save info to file button in dashboard
- You can reload the state of my application by pressing the load from file button in the login console

*Phase 4: Task2*:
A representative sample of log entries:

Fri Mar 28 12:43:01 PDT 2025
New Earning added.

Fri Mar 28 12:43:39 PDT 2025
New Earning added.

Fri Mar 28 12:44:09 PDT 2025
New expense added.

Fri Mar 28 12:44:14 PDT 2025
Amount added to savings.

*Phase 4: Task 3*:
I would fefactor different app frames into a shared hierarchy. Currently, in my code, BudgetManagerUI, LoginFrame, and ScreenPrinter are all three different entities. BudgetManagerUI calls both LoginFrame and ScreenPrinter according to its need and then disposes it accordingly through its methods. However, I do not have a clear association between the two. So, my structure of the code is not representative of the relationship of those classes. Along with that, LoginFrame and ScreenPrinter are technically components of the main BudgetManagerUI app with their own functionality. What I could do is refactor both into an interface called AppFrame which ensures the given frame is implementable in the app. ScreenPrinter and LoginFrame implements that interface. BudgetManagerUI would then only have many instances of AppFrame. 
