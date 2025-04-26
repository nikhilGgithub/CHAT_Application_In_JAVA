How to Start the Chit chat
Step 1 : Open power shell then past this path 

cd  "C:\Users\hp\Desktop\Work Space\multiuserchatapp"

after that ==>

cd bin

Now you are inside the bin folder. Start the server by running: after that  past this command 

java com.mycompany.chatapp.network.Server


Here ::Your server is now ready!  and go to make Client

To start a client, open a new PowerShell window (you can open multiple clients by opening multiple windows) and run:  Now past this command  to open multiple  client.

 java -cp ".;mysql-connector-java-8.0.11.jar" com.mycompany.chatapp.views.UserScreen

Important Note:
Every time you start the project, make sure you set the correct IP address in the config file!
