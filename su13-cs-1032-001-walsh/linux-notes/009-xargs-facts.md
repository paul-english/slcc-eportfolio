---
layout: page
title:  Xargs Facts
---

The **xargs** command reads items from the standard input and breaks up long
lists of arguments into smaller, usable lists. Xargs:

  * Makes it easier to pipe input into commands that take arguments.
  * Overcomes a 128 KB shell command size restriction in older Linux kernels.
  * Commonly takes input from the following commands:
    * **find**
    * **ls**
    * **locate**
    * **grep -l**

The following table describes the common **xargs** options:.

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td>Examples</td>

</tr>

<tr> <td><b>-0</b></td> <td>Ignore space names in files   </td> <td> <b>find /
-print0 -name *.odt | xargs -0 rm </b>deletes all .odt files in the file
system, even those with spaces in the file names.</td>

</tr>

<tr> <td><b>-I </b><i>variable</i></td> <td>Replace the initial argument of a
command with the argument from the standard input. </td> <td> <b>find / -name
'*.jpg' | xargs -I var1 cp var1 /home/user/Pictures</b> finds all the .jpg
files on the computer and copies them into the <b> /home/user/Pictures</b>
directory</td>

</tr> </table>

