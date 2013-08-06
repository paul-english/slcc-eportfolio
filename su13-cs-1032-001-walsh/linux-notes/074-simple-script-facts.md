---
layout: page
title:  Simple Script Facts
---

At its most basic level, a _script_ is a command or commands stored in a file.
When the shell reads the file, it executes the commands as if they were typed
at the keyboard. When using scripts, remember to do the following:

  * Specify the shell used to run the script, such as bash, csh, or ksh.
  * Use comments to explain what the script does.
  * Assign _execute_ permissions to the script with the script with the **chmod** command, and use the SUID bit to force the script to run with the permissions of the script owner, not with the permissions of the user who runs the script. 
  * Use **exit 0** to end the script.
  * Use one of the following methods to run the script: 

    * Add the folder that contains the script to the **PATH** environment variable, then type the script name in the present working directory.
    * Save the script in a folder that is already in the **PATH**, such as ** /usr/bin **or ** /bin**, then type the name of the script.
    * Type the full pathname to the script to run the script from anywhere. 
    * Type **./**_script_name_ to run the script in the present working directory. (**./** indicates the present working directory.)

The following table lists some simple scripting functions.

<table>

<tr> <td>Function</td> <td>Description</td> <td><b>Examples</b></td>

</tr>

<tr> <td>Specify the shell that runs the script</td> <td>The line that
specifies the shell must be the first line in the script. It starts with a
number sign and exclamation point (#!) and is followed by the path to the
shell executable.</td> <td><b>#! /bin/bash </b>specifies the script will run
in the bash executable.</td>

</tr>

<tr> <td>Add comments</td> <td>Comments begin with a number sign (#). The
shell ignores these lines when running the script. Comments help one
programmer to know how another programmer constructed the script, and help the
original programmer recall how the script was constructed.</td> <td><b>
</b></td>

</tr>

<tr> <td>Add commands </td> <td>When a script runs, it executes commands as if
they were typed on the command line.

Commands can be typed on a single line or separated using semi-colons (;). For
example, if a script contains <b>pwd</b> on a single line, when it executes,
it displays the current directory.

</td> <td><b>#! /bin/bash  
ls /home/user/Pictures  
exit 0</b>

This script uses the ls command to list the contents of the
/home/user/Pictures directory.

</td>

</tr>

<tr> <td>Use variables</td> <td><i>Variables</i> hold values that the script
uses when running. These values can be either numbers or test. When the script
uses a variable, it uses the value assigned to the variable. Keep the
following in mind when using variables:

<ul>

<li>Linux script variables commonly are written using all capital letters.
This helps programmers quickly identify them.

</li>

<li>When creating variables, place the equals (=) symbol immediately after the
variable with no space.<i> </i>If a space follows the variable name, The
script treats it as a command, and tries to execute it.

</li>

<li>Use a space after the equals (=) symbol only when you want the variable to
be the output of a command.

</li>

<li>Use quotes if a variable value has a space in it. It is a good practice to
always use quotes when you want a variable to represent a character string.

</li>

</ul> </td> <td><b>VARIABLE1=Hello</b> assigns <i>VARIABLE1</i> the value of
<i>Hello</i>.  
<b>VARIABLE1 = Hello </b>causes an error because the script tries to run the
command <i>VARIABLE1</i>, which by default does not exist.  
<b>VARIABLE1="Hello, Mr. Smith"</b> assigns <i>VARIABLE1</i> the value of <i>
Hello, Mr. Smith</i>.  
<b>VARIABLE1=Hello, Mr. Smith</b> assigns <i>VARIABLE1</i> the value of <i>
Hello, </i>then displays an error because it treats <i>Mr</i>. as a command
and tries to execute it.  
<b>VARIABLE1=pwd</b> assigns <i>VARIABLE1</i> the value of <i>pwd</i>.  
<b>VARIABLE1= pwd</b> assigns <i>VARIABLE1</i> the value of the result of
running the <i>pwd</i> command. For example, <i>/home/jdoe</i>.</td>

</tr>

<tr><td>Display information on the screen</td> <td>The <b>echo</b> command
displays information on the screen. It can display a literal value or a
variable. Keep the following in mind:

<ul>

<li>It is a good practice to always use quotes when you want a variable to
represent a literal value.

</li>

<li>Use a dollar ($) symbol to display the value of a variable.

</li>

<li>Enclose a command with acute symbols (`) (below the ~ on a standard US
keyboard) to display the result of a command.

</li>

<li>Use a backslash (\\) to display special characters.

</li>

</ul> </td> <td><b>echo Hello</b> displays <i>Hello</i> on the screen.  
<b>echo Hello, Mr. Smith.</b> displays <i>Hello, Mr. Smith</i> on the screen.  
<b>echo "Hello, Mr. Smith."</b> displays <i>Hello, Mr. Smith.</i> on the
screen.  
<b>echo \"Hello, Mr. Smith\"</b> displays <i>"Hello, Mr. Smith."</i> on the
screen.  
<b>echo pwd</b> displays <i>pwd</i> on the screen.  
<b>echo `pwd`</b> displays the result of running the <i>pwd</i> command. For
example, <i>/home/jsmith</i>.  
<b>echo $VARIABLE1</b> displays the value of <i>VARIABLE1</i>.  
<b>echo \$VARIABLE1</b> displays the literal string <i>$VARIABLE1</i>.</td>

</tr>

<tr> <td>Get user input</td> <td>The <b>read</b> command creates a variable
and prompts the user to type text. It assigns to the variable the value the
user types. By default, the user input is treated as a text string. </td>
<td><b>#! /bin/bash  
echo "What is your name?"  
read VARIABLE1  
echo "Hello," $VARIABLE1"."  
exit 0</b>

The script prints <i>What is your name?</i> on the screen, prompts the user
for input, then displays the input in the sentence <i> Hello, <input>.</i>

</td>

</tr>

<tr> <td>Declare integers or functions in the text</td> <td>The <b>declare
-i</b> command is used to change the numeric strings into integers. Use the
command in the script before populating variable values.  
The <b>declare -f</b> command is used to declare functions in a script. A
<i>function</i> associates a shortcut (called the function name) with a set of
commands.</td> <td><b>#! /bin/bash  
NUM1=7  
NUM2=5  
TOTAL=$NUM1+$NUM2  
echo $TOTAL  
exit 0</b>

This script gives an output of the text string <i>7+5</i> because the shell
treats the variable values as text charters.

<b>#! /bin/bash  
declare -i NUM1  
declare -i NUM2  
declare -i TOTAL  
NUM1=7  
NUM2=5  
TOTAL=$NUM1+$NUM2  
echo $TOTAL  
exit 0</b>

This script gives an output of the integer <i>12</i> because the shell treats
the variable values as integers.

<b>Note:</b> Numeric text strings can also be converted to integers using the
following format:  
<b>echo $[$NUM1+$NUM2] </b>gives an output of 12 regardless of whether the
<i>declare</i> command is used.

</td>

</tr> </table>

