![UltraJoin Logo](https://ericscott.co.uk/img/ultra/ULTRAJOIN.png)
# Welcome to UltraJoin

UltraJoin allows you to modify player first join, join and leave messages for your Spigot server.

## Features
* PlaceholderAPI Integration
* Customise your Join / Leave messages
* First join messages
* Ability to disable all Join / Leave messages

## Commands & Permissions
To find a list of commands and permissions, click [here](https://github.com/ericscott-uk/ultrajoin/wiki/UltraJoin-Wiki).

## Wiki
You can go to our wiki by clicking here: [https://github.com/ericscott-uk/ultrajoin/wiki/UltraJoin-Wiki](https://github.com/ericscott-uk/ultrajoin/wiki/UltraJoin-Wiki)

## Links

* [SpigotMC Page](https://google.com)
* [Found an issue?](https://github.com/ericscott-uk/ultrajoin/issues)

## Contact

You can get in contact with me through these methods:

 - Discord: `eric#9637`
 - Email: `me@ericscott.co.uk`

## Compiling (advanced)

To compile UltraJoin you'll need:

 - Maven ([\[windows\]](https://docs.wso2.com/display/IS323/Installing+Apache+Maven+on+Windows) [\[linux\]](https://linuxize.com/post/how-to-install-apache-maven-on-ubuntu-18-04/))
 - Java 8+

Start by cloning this repository into a folder on your filesystem, doesn't really matter where as long as you can navigate to it in the command line.
In a command line, run the following commands:

    cd <your directory here>
    git clone git@github.com:ericscott-uk/ultralibs.git
    git clone git@github.com:ericscott-uk/ultrajoin.git
UltraLibs is a dependency required by UltraJoin, it contains a couple of additional libraries for my plugins. Next you'll want to go into the UltraLibs project directory in a command line and run:

    mvn clean install
This may take up to a couple of minutes, since it needs to download a couple of dependencies for the library to compile correctly. Once this has completed, go to the UltraJoin directory and run the same command.
Now when these commands are done, you can go into the UltraJoin "target" directory (located inside the UltraJoin project) and find the file named "UltraJoin-X.X-SNAPSHOT.jar".
This can be simply dragged and dropped into your server and restarted.
