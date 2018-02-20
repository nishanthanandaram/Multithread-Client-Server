Program Details
===============

The attachment contains two programs that implements Message-oriented client-server communication
in two ways - one is a single threaded model, the other being a multi threaded model.

The program is currently tested to work locally, and is tested to work with the Windows Operating System.

Compiling and Running the Single Threaded Program
=================================================

1. Navigate to the 'Single Thread' directory of the project. This is where the .java files are stored.
2. Compile the server program by opening a command line in the directory and typing :
              javac Server.java
3. Compile the client program by opening a command line in the directory and typing :
              javac Client.java
4. Run the server program by running the command :
              java Server
5. Open a new command line window with the active directory being the 'Single Thread' directory.
6. Run the client program by running the command :
              java Client

Using the Single Threading Program
==================================

Once the program is running, the user is presented with the following options :

              PUT [filename]
              GET [filename]
              DELETE [filename]
              RENAME [old_filename][new_filename]
              QUIT


PUT is used to upload files to the server.
GET is used to download files from the server.
DELETE is used to delete a file from the server.
RENAME is used to rename a file that is currently on the server.
QUIT is used to quit the current program.

Uploading Files to the Server
-----------------------------

To upload files to the server, the following command needs to be typed in :

              PUT filename.txt

Where filename.txt is the file you want to upload to the server. You need to
ensure that the file you want to upload is in the project folder,
which is one directory above the "Single Thread" folder.(If Eclipse, Same folder if cmd)

Downloading Files from the Server
---------------------------------

Files can only be downloaded from the current user's directory. Before downloading,
please check if the file you want to download is in the current user's directory
by using the LS command. To download a file currently in the server :

              GET filename.txt

Where filename.txt is the file you want to download to the server.
Once the file is downloaded, you should see it in the project folder (One folder
above "src") with the prefix "From_Server_"

Deleting a File on the Server
-----------------------------

To delete a file on the server, the following command is used :

            Delete filename.txt

Where filename.txt is the file on the server you want to delete.

Renaming a File on the Server
-----------------------------

To delete a file on the server, the following command is used :

            Rename old_filename.txt,new_filename.txt

Where old_filename.txt is the old name of the file on the server you want to
rename, and new_filename.txt is the new name you want to give the file.

Compiling and Running the Multi Threaded Program
================================================

1. Navigate to the 'Multithread' directory of the project. This is where the .java files are stored.
2. Compile the server program by opening a command line in the directory and typing :
              javac Server.java
3. Compile the client program by opening a command line in the directory and typing :
              javac Client.java
4. Run the server program by running the command :
              java Server
5. Open a new command line window with the active directory being the 'Multithread' directory.
6. Run the client program by running the command :
              java Client
7. In Authentication.java - User Names and Passwords are stored in the file login.txt.
   Please make sure the path mentioned in this file is according to the folder structure in
   your system.

Using the Multi Threading Program
=================================

The multi threading program is a multi user program where a user is authenticated with
their own user id and password. To login to this program, the following credentials
are used :

          Login    : nishanth
          Password : nishanth

When the program is executed, the user is shown the following options :

              USER
              QUIT

To login, the user must type "USER <login> <password>". (User name and Passwords are stored in login.txt)

For eg : USER nishanth nishanth

Once a user logs in, the user is presented with the following options :

              PUT [filename]
              GET [filename]
              DELETE [filename]
              RENAME [old_filename],[new_filename]
              QUIT


PUT is used to upload files to the server.
GET is used to download files from the server.
DELETE is used to delete a file from the server.
RENAME is used to rename a file that is currently on the server.
QUIT is used to quit the current program.

Uploading Files to the Server
-----------------------------

To upload files to the server, the following command needs to be typed in :

              PUT filename.txt

Where filename.txt is the file you want to upload to the server. You need to
ensure that the file you want to upload is in the project folder,
which is one directory above the "src" folder.

Downloading Files from the Server
---------------------------------

Files can only be downloaded from the current user's directory. Before downloading,
please check if the file you want to download is in the current user's directory
by using the LS command. To download a file currently in the server :

              GET filename.txt

Where filename.txt is the file you want to download to the server.
Once the file is downloaded, you should see it in the project folder (One folder
above "src") with the prefix "From_Server_"

Deleting a File on the Server
-----------------------------

To delete a file on the server, the following command is used :

            Delete filename.txt

Where filename.txt is the file on the server you want to delete.

Renaming a File on the Server
-----------------------------

To delete a file on the server, the following command is used :

            Rename old_filename.txt new_filename.txt

Where old_filename.txt is the old name of the file on the server you want to
rename, and new_filename.txt is the new name you want to give the file.
