---
layout: page
title:  Grub Facts
---

The Grand Unified Boot Loader (GRUB) is a utility that boots a Linux kernel,
or any other operating system. GRUB:

  * Has two stages:
    * Stage 1 is the information stored in the master boot record. It holds the location of the boot information.
    * Stage 2 is the operating system software located on the boot partition.
  * Uses a menu to allow the user to select between multiple operating systems.
  * Loads a default operating system after a specified time period.
  * Creates a GRUB root using the **/boot **directory. The GRUB root contains the installed Stage 2 files. 
  * Omits** /boot** from the path if the **/boot** directory is in a separate partition.
  * Uses the **hd#,#** syntax to specify the location of the root file system.
  * Is installed by most distributions. If it was not installed, use the **grub-install** command from the shell prompt to install GRUB. For example, use **grub-install --root-directory=/boot sd1** to install GRUB on the second hard drive. 
  * Uses one of the following as the configuration file:

    * **/boot/grub/menu.lst**
    * **/boot/grub/grub.conf**

The following table describes several common options in the configuration
file:

<table>

<tr> <td>Use...</td> <td>To...</td> <td>Examples</td>

</tr>

<tr> <td><b>default</b></td> <td>Specify the operating system that boots as
the default. The value may be the entry number (e.g., 0, 1, 2) or the name of
the entry (e.g., Fedora).</td> <td><b>default=0</b> boots the first operating
system in the menu.  
<b>default=Fedora</b> boots the operating system with Fedora as the
title.</td>

</tr>

<tr> <td><b>timeout</b></td> <td>Set the number of seconds GRUB waits before
automatically booting the default operating system.</td> <td><b>timeout=10</b>
waits 10 seconds before booting the default operating system.</td>

</tr>

<tr> <td><b>gfxmenu  
splashimage</b></td> <td>Specify the image file which is displayed for the
graphical boot menu. </td> <td><b>splashimage=(hd0,0)/grub/splash.xpm.gz</b>
identifies the default splash image.</td>

</tr>

<tr> <td><b>hiddenmenu</b></td> <td>Disable/Enable the menu that lists the
operating system options.

<b>Note</b>: Adding the pound (#) symbol to this line only prevents the
operating systems from being displayed on startup. If the user hits any key
before GRUB selects the default operating system, the operating systems are
displayed.

</td> <td><b>hiddenmenu</b> disables GRUB from displaying the available
operating systems.  
<b>#hiddenmenu</b> displays the available operating systems.</td>

</tr>

<tr> <td><b>title</b></td> <td>Specify the title a user sees in the menu.</td>
<td><b>title Fedora </b>displays an option that is named Fedora.</td>

</tr>

<tr> <td><b>root</b></td> <td>Specifies the location of the root file
system.</td> <td><b>root (hd0,0)</b> specifies the first partition on the
first hard drive as the root file system.<b>  
root (hd0,1)</b> specifies the second partition on the first hard drive as the
root file system.  
<b>rootnoverify (fd0)</b> specifies the floppy drive as the root file system
and that it should be loaded regardless of whether GRUB recognizes it.</td>

</tr>

<tr> <td><b>kernel</b></td> <td>Specifies the kernel for the entry and kernel
options.</td> <td><b>kernel /vmlinuz-2.6.33.3-85.fc13.i686</b></td>

</tr>

<tr> <td><b>initrd</b></td> <td>Specifies the initial RAM disk (initrd image)
file. </td> <td><b>initrd /initramfs-2.6.33.3-85.fc13.i686.img</b></td>

</tr>

<tr> <td><b>chainloader</b></td> <td>Specify the number of sectors to be
read.</td> <td><b>chainloader +1</b> specifies that GRUB should read one
sector.</td>

</tr>

<tr> <td><b>password</b></td> <td>Require authentication for the options in
the GRUB menu. To create an encrypted password:

<ol>

<li>In a shell prompt, type <b>grub-md5-crypt</b>.

</li>

<li>At the prompt, type and confirm the password, then press return.

</li>

<li>Copy the hashed output from the shell.

</li>

<li>Type <b>password --md5</b> <i>hashed_output</i> in the GRUB configuration
file.

</li>

</ol> </td> <td><b>password  $3cur3</b> sets the string <i>$3cur3</i> as the
password.  
<b>password --md5 $1$frLco/$/E4pglv5halSBQadGQgb1 </b>uses the hashed output
for the password.</td>

</tr>

<tr> <td><b>lock</b></td> <td>Prevent unauthorized boot of the operating
system. When the <b>lock</b> keyword is present for an operating system, the
password is required before the user can select and boot an operating
system.</td> <td> </td>

</tr> </table>

