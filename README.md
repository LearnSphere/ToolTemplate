Carnegie Mellon University, Human-Computer Interaction Institute.
Copyright 2015. All Rights Reserved.
Author: Mike Komisin


General dependencies

1. R, Ant, and the Java SDK are installed on the development machine.
2. Install one of Eclipse or Cygwin or both
3. Install git



Downloading the example project

4. Clone the git repository:
	cd /cygdrive/c/your_workspace
	git clone https://github.com/datashop-manager/ToolTemplate.git ToolTemplate



Eclipse

1. File -> Import -> General -> Existing Projects into Workspace
2. Select the root directory of the newly clone git repository (C:/your_workspace/ToolTemplate)
3. Click 'Finish'
4. In the Ant view (Windows -> Show View -> Ant), add the ToolTemplate's build.xml to your current buildfiles
5. Double click the ant task "runToolTemplate" to test that it works



Cygwin

1. Change directory to /cygdrive/c/your_workspace/ToolTemplate
2. Type ant -p to get a list of ant tasks
3. Type "ant runToolTemplate" to test that it works



*Note: Project tested with latest R (3.2.1), Ant 1.9.4+, and the Java EE 7 SDK

