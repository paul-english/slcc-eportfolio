---
layout: page
title:  Help Facts
---

Help pages are part of every Linux distribution. They provide information
about options and uses for the nearly 1000 commands that are available on a
Linux computer. The following table describes help options available for a
Linux system.

<table>

<tr> <td>Option</td> <td>Description</td> <td><b>Examples</b></td>

</tr>

<tr> <td>Man page</td> <td>

A <i>manual</i> (man) page is text-based help file for a specific command
stored on the computer. A man page shows the command's syntax, options, and
related files and commands. Be aware of the following details:

<ul>

<li>The <b>man</b> command opens the corresponding file in the command prompt
window using the default paging program.

</li>

<li>Man pages are typically stored in the<b> /usr/man</b> or
<b>/usr/share/man</b> directory. Subdirectories store man pages for different
types of commands or languages.

</li>

<li>The MANPATH environment variable can be altered to specify a different
location for man pages.

</li>

<li>Some distributions set this variable using the <b>/etc/man.config</b>
script, with corresponding scripts in each user's home directory to allow
variation for individual users.

</li>

<li>Press Q to exit the man page.

</li>

<li>Use the <b>-k</b> option to search the man pages for a command.

</li>

</ul> </td> <td><b>man userdel</b> shows the man pages for the <b>userdel</b>
command.  
<b>man man</b> shows the man pages for the <b>man</b> command.  
<b>man -k user</b> lists all the commands with <i>user</i> in the command name
or description.</td>

</tr>

<tr> <td>Info pages</td> <td>For GNU software, info pages are the primary
documentation source. Info pages use hypertext links to navigate the pages.
Use the following keys to navigate through an info page:

<ul>

<li><i>h</i> shows a navigation help screen.

</li>

<li><i>Tab</i> moves to the next hyperlink.

</li>

<li><i>Home</i> moves to the beginning of a node.

</li>

<li><i>Enter</i> follows the selected hyperlink.

</li>

<li><i>u</i> moves up a node level.

</li>

<li><i>Space</i> moves to the next screen.

</li>

<li><i>Del</i> moves to the previous screen.

</li>

<li><i>q</i> exits an info page.

</li>

</ul> </td> <td>

<b>info mkfifo</b> opens the info page for the <b>mkfifo</b> command.  
<b>info man</b> opens the info page for the <b>man</b> command.

</td>

</tr>

<tr> <td>On-screen help</td> <td>Many commands include on-screen help as one
of the options for the command. In most cases, help displays an abbreviated
list that shows of the command syntax and available options with brief
descriptions. If the command is typed incorrectly, many commands display the
help information automatically.

To view the help available for a command, type<i>:</i>

<ul>

<li><i><b>command</b></i><b> \--help</b>

</li>

<li><b><i>command</i></b> <b>-h</b>

</li>

</ul>

Although some commands support both switches, the <b>\--help</b> switch is
more common. If necessary, use the <b>more</b> command to scroll through the
on-screen help.

</td> <td>

<b>jobs --help</b> for help with the <b>jobs</b> command.  
<b>echo -h</b> for help with the <b>echo</b> command.

</td>

</tr>

<tr> <td>whatis database</td> <td> The whatis database is an index of the man
pages on the system. Use the whatis database to find man pages that contain a
specific word (i.e., search string).

<ul>

<li>Run<b> /usr/sbin/makewhatis</b> to create the whatis database. The
database must be created first.

</li>

<li>Use <b>makewhatis -u </b>to update the database after changes have been
made to the man pages.

</li>

</ul>

The following commands will return a list of the man pages containing the
search string in the whatis database:

<ul>

<li><b>apropos</b> <i>searchstring</i>

</li>

<li><b>whatis</b> <i>searchstring</i>

</li>

</ul> </td> <td><b>makewhatis -u</b> updates the database.  
<b>apropos</b> <b>grep </b>returns all man pages containing the term <i>
grep</i>.</td>

</tr> </table>

