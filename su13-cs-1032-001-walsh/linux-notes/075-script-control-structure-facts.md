---
layout: page
title:  Script Control Structure Facts
---

In addition to the basic commands, scripts can contain the following types of
control structures:

  * _Branching structures _let scripts perform different actions based on specific conditions or user input.
  * _Looping structures_ repeat a specified set of commands according to a specified set of conditions specified in the script.

The following table describes the commands and statements used to create
control structures:

<table>

<tr> <td><b>Structure</b></td> <td><b>Description</b></td>
<td><b>Examples</b></td>

</tr>

<tr> <td>Sequences</td> <td>Use the <b>seq</b> command to create a sequence of
numbers. Command structure can take any of the following forms:

<ul>

<li>When using only one number in the command, <b>seq</b> starts at 1 and
counts to the specified number.

</li>

<li>When two numbers are given in the command, <b>seq</b> begins with the
first number and counts up to the second number.

</li>

<li>When three numbers are given in the command, <b>seq</b> starts at the
first number and counts in increments of the second number up to the third
number.

</li>

</ul> </td> <td><b>seq 10</b> counts from 1 to 10.  
<b>seq 5 15</b> starts at 5 and counts to 15.  
<b>seq 5 5 100</b> starts at 5 and counts to 100 in increments of 5. (for
example 5, 10, 15, 20...)  
<b>seq 10 -1 -10</b> starts at 10 and counts down to -10.</td>

</tr>

<tr> <td>Testing conditions</td> <td>The <b>test</b> command is used to
evaluate whether a condition is true or false. <b>test</b> is commonly used in
conjunction with <b>if, then, else</b> statements in a shell script.
<b>test</b> options include:

<ul>

<li><b>-d</b> tests whether a directory exists.

</li>

<li><b>-e</b> tests whether a file exists.

</li>

<li><b>-f</b> tests whether a regular file exists.

</li>

</ul>

Operands for <b>test</b> include:

<ul>

<li><b>=</b> tests whether strings are equivalent.

</li>

<li><b>!=</b> tests whether strings are not equivalent.

</li>

<li><b>-o</b> is used to specify that either of the options can be equivalent.

</li>

<li><b>-eq</b> tests whether integers are equivalent.

</li>

<li><b>-ne</b> tests whether integers are not equivalent.

</li>

<li><b>-gt</b> tests whether the first integer is greater than the second.

</li>

<li><b>-lt</b> tests whether the first integer is less than the second.

</li>

</ul> </td> <td><b>test -f ~/myfile.txt </b>determines whether a file named
<i>myfile.txt</i> exists in the user's home directory.<b>  
test -d ~/bin </b>determines whether a directory named <i>bin</i> exists in
the user's home directory.<b>  
test $NAME = "George Washington"</b> determines whether the value if the <i>
$NAME</i> variable is <i>George Washington</i>.  
<b>test $NAME -o $NAME2 = "George Washington"</b> determines whether the value
if either the<i> $NAME </i>or the<i> Name2</i> variable is <i>George
Washington</i>.  
<b>test $NUM1 -le $NUM2</b> determines whether the value of the variable <i>
NUM1</i> is less than the value of the variable <i>NUM2</i>.</td>

</tr>

<tr> <td>If, then, else statements</td> <td>Use <b>if</b>, <b>then</b>,
<b>else</b> statements to evaluate conditions. When using these statements,
keep the following in mind:

<ul>

<li>The <b>if</b> command defines the condition to be evaluated.

</li>

<li>The <b>then</b> command specifies the commands to perform if the condition
is true.

</li>

<li>The <b>else</b> command specifies the commands to perform if the condition
is false.

</li>

<li>Operands include:

<ul>

<li>= (equal to)

</li>

<li>!= (not equal to)

</li>

<li>> (greater than)

</li>

<li>< (less than)

</li>

</ul>

</li>

<li>The <b>if</b> command requires spaces between the conditions and the
operand.

</li>

<li>The <b>if</b> command also requires spaces between the conditions and the
brackets ('[' and ']').

</li>

<li>The statements must be closed using the <b>fi</b> command.

</li>

</ul> </td> <td><b>#! /bin/bash  
echo "What is your name?"  
read NAME  
if [ $NAME = "George" ]  
  then  
    echo "That's my name too."  
  else  
    echo "Hello" $NAME "I'm George."  
fi  
exit 0</b>

The script takes the user input and evaluates it to determine whether the user
types <i>George</i>. If the user types <i>George</i>, the script responds with
<i>That's my name too. </i>Otherwise, the script responds with the statement
under the <i>else</i> command.

Note: The if statement can also be written using the test command. For
example, <i>if test $NAME = "George"</i>.

</td>

</tr>

<tr> <td>Case statements</td> <td>Use the <b>case</b> command to write
conditional scripts that have several possible options. When using case
commands, keep the following in mind:

<ul>

<li>Case statements can have an unlimited number of possible options.

</li>

<li>When the script evaluates an option as being true, all remaining options
are skipped.

</li>

<li>Each option can execute several lines of commands. Close each case with
two semi-colons.

</li>

<li>Case statements must be closed using <i>esac</i> (case spelled backwards.)

</li>

</ul> </td> <td><b>#! /bin/bash  
echo "What is your favorite season?"  
read SEASON  
case $SEASON in  
  spring) echo "The thing I like best about spring is the flowers."  
  ;;  
  summer) echo "I wish I could go swimming, but being a computer, that might
not work out so well."  
  ;;  
  fall) echo "Fall leaves, Thanksgiving...what's not to like?"  
  ;;  
  autumn) echo "Fall leaves, Thanksgiving...what's not to like?"  
  ;;  
  winter) echo "Skiing looks fun, but snowstorms interfere with my reception
of the neighbor's WiFi."  
  ;;  
  *) echo $SEASON "is not listed in my database as being a season. Choose: spring, summer, fall, autumn, or winter."   
  ;;  
esac  
exit 0</b>

The script asks the user about season preferences and has a response for each
common answer. The last option is a catch-all for any answer other than those
specified in the script.

</td>

</tr>

<tr> <td>While loops</td> <td>The <b>while</b> loop continuously executes all
commands between the <i>do</i> and <i>done</i> statements while a specific
condition exists. <b>while</b> loops are useful for repeating an action until
a specified value is met. Keep the following in mind when using <b>while</b>
loops:

<ul>

<li><b>while</b> loops require <i>do</i> and <i>done</i> statements.

</li>

<li><b>while</b> loops can create infinite loops that lock up a terminal. For
example, the following statement creates an infinite loop because the
condition needed to exit the loop can never be met:  
<b>while test $VAR != "Done!"; do VAR="Not done yet!"; done</b>

</li>

<li>Pressing Ctrl+C sends an interrupt signal to the process to terminate an
infinite loop.

</li>

</ul> </td> <td><b>#! /bin/bash  
declare -i NUM  
echo "I'm thinking of a number between 1 and 100."  
# Give NUM a value to prevent errors.  
NUM=0  
while test $NUM -ne 23  
  do  
    echo "What is your guess?"  
    read NUM  
    if test $NUM -lt 23  
      then  
        echo "The number is higher."  
    fi    
    if test $NUM -gt 23  
      then  
        echo "The number is lower."  
    fi    
  done  
echo "You guessed it."  
exit 0</b>

The script uses a <b>while</b> loop to keep the user guessing numbers until
they get the answer. As long as the number is not 23, the if statements keep
giving the user clues as to whether the number is higher or lower. As soon as
the user types 23, the <b>while</b> loop exits and the final statement
displays telling the user that the guess is correct.

</td>

</tr>

<tr> <td>Until loops</td> <td>An <b>until</b><i> </i> loop is nearly identical
to a <b>while</b><i> </i> loop, but only opposite:

<ul>

<li>The <b>while</b> loop executes commands <i>while</i> a condition is true.

</li>

<li>The <b>until</b> loop executes commands <i>until</i> a condition is true.

</li>

</ul>

The <b>while </b>loop example could be changed into an until loop by changing
6th line to:  
<b>until test $NUM -eq 23</b>

</td> <td><b>#! /bin/bash  
declare -i NUM  
echo "I'm thinking of a number between 1 and 100."  
# Give NUM a value to prevent errors.  
NUM=0  
until test $NUM -eq 23  
  do  
    echo "What is your guess?"  
    read NUM  
    if test $NUM -lt 23  
      then  
        echo "The number is higher."  
    fi    
    if test $NUM -gt 23  
      then  
        echo "The number is lower."  
    fi    
  done  
echo "You guessed it."  
exit 0</b></td>

</tr>

<tr> <td>For loops</td> <td>

A <b>for</b> loop is a shell structure that executes a set of commands a set
number of times. A <b>for</b> loop:

<ul>

<li>Is useful when a specific action needs to be done a set number of times.

</li>

<li>Executes all commands between the do and done statements. These are
required.

</li>

<li>Can be used with a list of items with one action being done for each item
in the list.

</li>

</ul> </td> <td><b>#!/bin/bash  
declare -i NUM  
echo "Multiplication quiz!!!"  
echo "Which set of multiplication tables do you want to drill?"  
read NUM  
echo "OK. We'll work on 0X"$NUM "through 12X"$NUM"."  
for LOOP in $(seq 0 12)  
  do  
  echo "What is" $NUM "X" $LOOP"?"  
  read ANSWER  
  if test $ANSWER -eq $[$NUM*$LOOP]  
    then  
      echo "That is correct!"  
    else  
      echo "That's not it. The correct answer is" $[$NUM*$LOOP]"."  
  fi  
done  
exit 0 </b>

The script uses a <b>for</b> loop to ask the correct number of multiplication
questions. The loop starts at 0 and loops through from 0 to 12.  This ensures
that the correct number of questions are asked.

<b>Note:</b> The script uses the <b>seq</b> command to create the loop
sequence. Other methods to create a <b>for</b> loop include:

<ul>

<li><b>for LOOP in 1 2 3 4 5</b> counts from 1 to 5.

</li>

<li><b>for LOOP in {1..5}</b> counts from 1 to 5.

</li>

<li><b>for LOOP in {0..10..2}</b> counts from 0 to 10 in increments of 2.

</li>

</ul> </td>

</tr> </table>

