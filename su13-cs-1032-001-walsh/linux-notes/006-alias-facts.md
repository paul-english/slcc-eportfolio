---
layout: page
title:  Alias Facts
---

An _alias_ is a custom command that performs a specific action. Most
distributions have aliases that are invoked at startup; however, an alias can
be invoked from the shell. Be aware of the following:

  * Aliases defined with the **alias** command are _not_ persistent across reboots. 
  * Add the alias to **/etc/profile** or **home/_user_/.bashrc** to make them persistent across reboots. 

The following table describes the commands that create and remove aliases.

<table>

<tr> <td>Use...</td> <td>To...</td> <td>Example</td>

</tr>

<tr> <td><b>alias</b></td> <td>Display the currently defined aliases on the
system.</td> <td> </td>

</tr>

<tr> <td><b>alias </b><i>name</i></td> <td>Create a custom command that:

<ul>

<li>Adds additional functionality to an existing command.

</li>

<li>Performs multiple functions.

</li>

</ul>

<b>Note</b>: When creating the alias, encapsulate the command(s) with
quotation marks or apostrophes.

</td> <td><b>alias ls='ls --ignore=*.elf' </b>prevents the ls command from
displaying .elf files even if <b>ls -a</b> is used.  
<b>alias securebackup='cp ./*.* /dev/st0/*.*;shred -fuvz ./*' </b> creates a
command that copies all files to the storage tape, then shreds the original
files.  
<b>alias forcelogout="killall /usr/bin/Xorg" </b>creates a shortcut kills all
Xserver processes.</td>

</tr>

<tr> <td><b>unalias</b> <i>name</i></td> <td>Remove an alias.</td>
<td><b>unalias ls</b> removes all aliases specified for the <b>ls</b> command
and places it back in its original state.  
<b>unalias forcelogout</b> deletes the forcelogout alias if it exists.</td>

</tr> </table>

