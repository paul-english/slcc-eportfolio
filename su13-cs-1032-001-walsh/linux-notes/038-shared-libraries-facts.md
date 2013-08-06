---
layout: page
title:  Shared Libraries Facts
---

_Shared libraries_ are code loaded into memory and reused by several different
programs. This allows the program file size to be relatively small, as it will
use a shared amount of library code when necessary. In addition, updated code
within the shared libraries allows each applicable program to take advantage
of the improvements. Shared libraries can create the following software
management complications:

  * Changes in the shared library can be incompatible with some of the programs that use the library. 
  * Programs may not be able to locate the shared library. 
  * A shared library can become inaccessible if it is overwritten or updated. For instance, problems may occur if two different packages that include the same shared library are installed. 

There a two types of shared libraries:

<table>

<tr> <td><b>Type</b></td> <td><b>Description</b></td>

</tr>

<tr> <td>Dynamic</td> <td><i>Dynamic libraries</i> are not integrated into the
code of the application. Dynamic libraries:

<ul>

<li>Have a <b>.so</b> or <b>.so.<i>version</i></b> extension (<b>.so</b>
stands for shared object).

</li>

<li>Are typically stored in<b> /usr/lib/</b> and <b>/usr/local/lib/</b>.

</li>

<li>Can degrade program load time if the library isn't already in use by
another program.

</li>

<li>Are similar to Dynamic Link Libraries (DLLs) in Windows.

</li>

</ul>

Be aware of the following management programs and files for dynamic libraries:

<ul>

<li><b>/lib/ld.so </b>is a program which finds and loads the shared libraries
needed by a program. It also prepares the program to run and executes it.

</li>

<li><b>/etc/ld.so.conf</b> is a file which contains a list of colon, space,
tab, newline, or comma-separated directories in which to search for libraries.
Some lines in the file begin with the <b>include</b> directive which list
files that are to be included as if they were part of the part of the main
file.

</li>

<li><b>/etc/ld.so.cache </b>is a cached list of libraries found in the
directories specified in <b>/etc/ld.so.conf</b>. The system uses this cached
list instead of loading <b>/etc/ld.so.conf</b> every time a program runs.

</li>

</ul>

Use the following methods for configuring dynamic libraries on a Linux system:

<ul>

<li>Modify <b>/etc/ld.so.conf</b> to add the path of the libraries.

</li>

<li>Use the<b> LD_LIBRARY_PATH</b> environment variable to specify additional
directories to search for library files.

</li>

</ul> </td>

</tr>

<tr> <td>Static</td> <td><i>Static libraries</i><b> </b>are integrated into
the code of the application when the code is compiled. Static libraries:

<ul>

<li>Have an <b>.a</b> filename extension.

</li>

<li>Are used when dynamic libraries are not available.

</li>

<li>Increase the size of the application.

</li>

</ul> </td>

</tr> </table>

Be aware of the following library management commands:

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td>

</tr>

<tr> <td><b>ldd</b> </td> <td>Discover which libraries are used by another
library (i.e., library dependencies).

<ul>

<li>When using <b>ldd</b> to track down problems, check the complete
dependency chain.

</li>

<li>Run <b>ldd</b> as root (recommended).

</li>

</ul>

Be aware of the following options:

<ul>

<li><b>-v</b> displays all information.

</li>

<li><b>-u</b> displays unused direct dependencies.

</li>

<li><b>\--version</b> displays the version number of <b>ldd</b>.

</li>

</ul> </td>

</tr>

<tr> <td> <b>ldconfig</b> </td> <td>Reload the library cache every time
libraries are added or removed, and update the symbolic links. This creates
the necessary links and cache for the most recent shared libraries found in
the directories specified on the command line, in the file
<b>/etc/ld.so.conf</b>, and in the trusted directories (<b>/lib</b> and
<b>/usr/lib</b>). Be aware of the following options:

<ul>

<li><b>-v</b> summarizes the directories and files it is registering as it
reloads the cache.

</li>

<li><b>-N</b> updates symbolic links, but does <i>not</i> update the cache.

</li>

<li><b>-n</b> updates the links contained in the directories specified on the
command line.

</li>

<li><b>-X</b> updates the cache but does <i>not</i> update symbolic links.

</li>

<li><b>-f</b> changes the configuration file from <b>/etc/ld.so.conf</b>
default.

</li>

<li><b>-C</b> changes the cache location for the <b>/etc/ld.so.cache </b>
default.

</li>

<li><b>-r</b> treats a new directory as if were the root directory. This is
helpful when you are recovering a badly corrupted system or installing a new
OS.

</li>

<li><b>-p</b> displays the current library cache, including all the library
directories and their respective libraries.

</li>

</ul> </td>

</tr> </table>

