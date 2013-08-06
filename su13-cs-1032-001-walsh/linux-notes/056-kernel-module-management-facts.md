---
layout: page
title:  Kernel Module Management Facts
---

When the system boots, it uses one of the following files to automatically
load kernel modules. (**Note**: The exact file used depends on the
implementation.)

<table>

<tr> <td><b>File</b></td> <td><b>Description</b></td>

</tr>

<tr> <td><b>/etc/modprobe.conf </b></td> <td>Provides the <b>modprobe</b>
utility with default commands for loading modules at boot time. Entries in the
file include the following:

<ul>

<li><b>install</b> loads a module at boot time.

</li>

<li><b>alias</b> specifies a name as an alias for a module name. This alias
can be used with module utilities.

</li>

<li><b>options </b>specifies options used while loading a module, including:

<ul>

<li><b>irq </b>for IRQ information

</li>

<li><b>io </b>for I/O port information.

</li>

</ul>

</li>

</ul> </td>

</tr>

<tr> <td><b>/etc/modprobe.d</b></td> <td>Contains multiple configuration files
used by <b>modprobe</b> at boot time if the<b> /etc/modprobe.conf</b> file
does not exist.</td>

</tr> </table>

Use the following commands to manage kernel modules manually:

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td><b>Example</b></td>

</tr>

<tr> <td><b>lsmod</b></td> <td>List all loaded modules. The command formats
information from the <b>/proc/modules </b>file. No options are associated with
<b>lsmod</b>.</td> <td> </td>

</tr>

<tr> <td><b>modinfo</b></td> <td>

See additional information about a module listed using the <b>lsmod</b>
command.

</td> <td><b>modinfo mii</b> shows information about the MII Hardware Support
Library module.</td>

</tr>

<tr> <td><b>depmod </b></td> <td>Create a file that lists module dependencies.
The file is placed at <b>
/lib/modules/</b><i>kernel_version_number</i><b>/modules.dep</b>. Read the
<b>/etc/modules.conf</b> file to identify modules. It then probes each module
to identify dependencies and builds a list of those dependencies. Be aware of
the following options:

<ul>

<li><b>-a </b>Shows information for all modules.

</li>

<li><b>-n </b>Shows what would happen on the screen rather but does not
perform the action.<b> </b>

</li>

<li><b>-v </b>Uses verbose mode.

</li>

</ul> </td> <td><b>depmod -an</b> performs the probe and display the results
on the screen.  
<b>depmod -v </b>displays all module information to the screen as it updates
the modules.dep file.</td>

</tr>

<tr> <td><b>insmod</b> </td> <td>Install modules into the kernel.

<ul>

<li><b>insmod</b> does not look for dependencies, and fails if a module has
unmet dependencies.

</li>

<li>Include the full name of the module, including the .o or .ko extension.

</li>

</ul> </td> <td><b>insmod mousedev.ko</b> loads the mousedev module.</td>

</tr>

<tr> <td><b>modprobe</b></td> <td>Load modules into the kernel along with any
module dependencies. This utility also runs at startup to load modules into
the kernel. The <b>/etc/modprobe.conf </b>file provides <b>modprobe</b> with
its configuration rules. Be aware of the following options:

<ul>

<li><b>-l</b> lists all loaded modules.

</li>

<li><b>-r</b> removes a module.

</li>

</ul> </td> <td><b>modprobe reiserfs</b> loads the reiserfs and all of its
dependant modules.<b>  
modprobe -r reiserfs</b> removes the reiserfs module.</td>

</tr>

<tr> <td><b>rmmod</b> </td> <td>Remove a module from the kernel. <b>rmmod</b>:

<ul>

<li>cannot unload the module if it is in use.

</li>

<li>Does not look for dependencies and can cause errors if a module depends on
a module that is unloaded.

</li>

</ul> </td> <td><b>rmmod mousedev</b> removes the mousedev module.</td>

</tr> </table>

