---
layout: page
title:  Grub2 Facts
---

The GRUB2, the updated version of the Grand Unified Boot Loader (GRUB)
utility, is any version of GRUB 1.98 or later. Earlier versions of GRUB are
sometimes known as GRUB Legacy. Be aware of the following details about GRUB2:

  * **/boot/grub/grub.cfg** is the configuration file for GRUB2. The configuration file:
    * Is similar to GRUB Legacy's** /boot/grub/menu.lst**.
    * Should _not_ be edited directly.
  * The **update-grub** command generates the **/boot/grub/grub.cfg** file. Specifically, the **update-grub** command uses the **/etc/default/grub **file and the **/etc/grub.d/ **directory** **to generate the **/boot/grub/grub.cfg** configuration file.

  * The **/etc/grub.d/** directory holds script files that are read when the** update-grub** command is used. Important script files in this directory include: 

<table>

<tr> <td>Script File</td> <td>Description</td>

</tr>

<tr> <td><b>00_header</b></td> <td>Sets initial appearance items such as the
graphics mode, default selection, timeout, etc. These settings are typically
imported from the <b>/etc/default/grub </b>file. </td>

</tr>

<tr> <td><b>05_debian_theme </b></td> <td>Sets the GRUB2 background image,
text colors, selection highlighting, and themes.</td>

</tr>

<tr> <td><b>10_linux </b></td> <td>Identifies kernels on the root device for
the operating system in use and creates menu entries.</td>

</tr>

<tr> <td><b>30_os-prober </b></td> <td>Executes<i><b> </b>os-prober<b>
</b></i>to search for other operating systems (i.e., Windows, Linux, etc.,)
and place the results in the GRUB2 menu.</td>

</tr>

<tr> <td><b>40_custom</b></td> <td>Allows for custom menu entries which are
imported directly into <b>/boot/grub/grub.cfg</b> without any changes.</td>

</tr> </table>

  * The **/etc/default/grub** file is the primary configuration file for changing menu display settings. The following table describes several common options in the configuration file:

<table>

<tr> <td>Option</td> <td>Description</td> <td>Examples</td>

</tr>

<tr> <td><b>GRUB_DEFAULT</b></td> <td>Sets the default menu entry. Typical
entries include:<ul>

<li>Numeric (i.e., 0, 1, 2, etc.)

</li>

<li>Complete menu entry quotation (i.e., "Ubuntu, Linux 2.6.31-9-generic")

</li> </ul></td> <td><b>GRUB_DEFAULT=0 </b>sets the first menu entry as the
default.  
<b>GRUB_DEFAULT="Ubuntu, Linux 2.6.31-9-generic" </b>sets a menu entry as the
default.</td>

</tr>

<tr> <td><b>GRUB_SAVEDEFAULT</b></td> <td>Automatically sets the last selected
OS from the menu as the default OS on the next boot.

<b>Note</b>: <b>GRUB_DEFAULT=saved</b> is required for this option to work
correctly.

</td> <td><b>GRUB_SAVEDEFAULT=true</b> sets the last selected OS from the menu
as the default OS on the next boot.</td>

</tr>

<tr> <td><b>GRUB_HIDDEN_TIMEOUT</b></td> <td>Determines how long a screen
without the GRUB 2 menu will be displayed. Options include:<ul>

<li><b>0</b> immediately boots to the default OS

</li>

<li><b>X</b> (an integer value) pauses and shows a blank screen for X seconds.
If a user presses any key, the GRUB menu is displayed.

</li>

<li>(blank) uses the value specified in the GRUB_TIMEOUT entry

</li> </ul></td> <td><b>GRUB_HIDDEN_TIMEOUT=0 </b>immediately boots to the
default OS.  
<b>GRUB_HIDDEN_TIMEOUT=3 </b>displays a blank screen for 3 seconds and then
boots to the default OS if there is no user interaction.</td>

</tr>

<tr> <td><b>GRUB_HIDDEN_TIMEOUT_QUIET</b></td> <td>Displays a counter
(countdown). Options include:<ul>

<li><b>true</b> does not display a counter

</li>

<li><b>false</b> displays the counter for the duration specified in the
GRUB_HIDDEN_TIMEOUT entry

</li> </ul></td> <td><b>GRUB_HIDDEN_TIMEOUT_QUIET=true </b>does not display a
counter.</td>

</tr>

<tr> <td><b>GRUB_TIMEOUT</b></td> <td>Determines how long to wait for user
interaction before booting into the default operating system. Options
include:<ul>

<li><b>X</b> (an integer value of 1 or higher) sets the display duration

</li>

<li><b>-1</b> causes the menu to display until the user makes a selection.

</li> </ul>

Be aware of the following:

<ul>

<li>The GRUB 2 menu is hidden by default unless another OS is detected by the
system.

</li>

<li>If there is no other OS, this line may be commented out unless the user
changes it.

</li> </ul></td> <td><b>GRUB_TIMEOUT=4</b> causes the menu to display for four
seconds and then boots into the default operating system.  
<b>GRUB_TIMEOUT=-1</b> causes the menu to display until the user makes a
selection.</td>

</tr>

<tr> <td><b>GRUB_CMDLINE_LINUX</b></td> <td>Adds entries to the end of the
'linux' command line (GRUB Legacy's "kernel" line) for both normal and
recovery modes. It is used to pass options to the kernel.</td> <td>  </td>

</tr>

<tr> <td><b>GRUB_GFXMODE</b></td> <td>Sets the resolution of the graphical
menu (i.e., the menu text size).  Multiple resolutions may be specified if
they are separated by commas.</td> <td><b>GRUB_GFXMODE=640x480</b> sets the
resolution to 640 x 480.</td>

</tr>

<tr> <td><b>GRUB_INIT_TUNE</b></td> <td>Plays a single beep just prior to the
GRUB2 menu display</td> <td>  </td>

</tr>

<tr> <td><b>GRUB_BACKGROUND </b></td> <td>Sets the background image during
GRUB2 menu display. The full path should be used.</td>
<td><b>GRUB_BACKGROUND=/usr/share/images/back.png</b> displays <i>back.png</i>
as the background image.</td>

</tr>

<tr> <td><b>GRUB_DISABLE_OS_PROBER</b></td> <td>Enables/disables the os-prober
check of other partitions for operating systems, including Windows, Linux,
etc., during execution of the <b>update-grub</b> command. If the os-prober is
enabled, operating systems found will be placed in the GRUB2 menu.</td>
<td><b>GRUB_DISABLE_OS_PROBER=true</b> disables the os-prober.  
<b>GRUB_DISABLE_OS_PROBER=false</b> enables the os-prober and will add found
operating systems to the GRUB2 menu.</td>

</tr> </table>

**Note**: Use the **grub-install -v **or **grub2-install -v** command to determine which version of GRUB is installed.

