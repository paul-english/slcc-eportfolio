---
layout: page
title:  Vim Commands
---

Vim (vi improved), also referred to as _vi_, is a utility that creates and
modifies text files. It is the standard command-line text editor included with
Linux distributions. Vim has the following modes:

  * _Command _ mode is the initial mode vim uses when started. It has commands that cut and replace text, and it is the mode vi uses to enter the other modes.
  * _Command line _mode_ _is the mode that works with the file system. Use it to save files after editing them.
  * _Edit _mode_ _is the mode that vim uses to write and edit text in the file. It has two operation modes:
    * _Insert _ mode adds text between the preceding and subsequent text.
    * _Replace _ mode overwrites subsequent text. 

The table below lists some of the most common vi commands.

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td><b>Mode</b></td>

</tr>

<tr> <td><b>vi</b></td> <td>Start vim. Type the command at the shell
prompt.</td> <td>N/A</td>

</tr>

<tr> <td><b>vi</b> <i>filename</i></td> <td>Start vim and immediately begin
working on the named file (either a new, non-existent file or an existing
file). Type the <b>vi</b> command at the shell prompt.</td> <td>N/A</td>

</tr>

<tr> <td><b>Insert</b> key  
<b>i  
s</b></td> <td>Enter insert mode from command mode</td> <td>Command</td>

</tr>

<tr> <td><b>Esc</b><i> </i>key</td> <td>Enter the command mode from the edit
mode.</td> <td>Insert/Replace</td>

</tr>

<tr> <td><b>Delete </b>key</td> <td>Delete text</td> <td>Insert/Replace</td>

</tr>

<tr> <td><b>Insert</b> key</td> <td>Change between insert and replace mode
while in edit mode.</td> <td>Insert/Replace</td>

</tr>

<tr> <td><b><i>#</i> </b>(line number)</td> <td>Go to a specific line in the
document while in command mode. For example <b>94</b>, moves the cursor to
line 94. </td> <td>Command</td>

</tr>

<tr> <td><b>dw</b></td> <td>Cut a whole word and trailing space.</td>
<td>Command</td>

</tr>

<tr> <td><b>de</b></td> <td>Cut a whole word but omit the trailing space.</td>
<td>Command</td>

</tr>

<tr> <td><b>d$ </b>or<b> D</b></td> <td>Cut all text following the cursor to
the end of the line.</td> <td>Command</td>

</tr>

<tr> <td><b>dd</b></td> <td>Cut a line from the text.</td> <td>Command</td>

</tr>

<tr> <td><b>p</b></td> <td>Place text in memory into the document.</td>
<td>Command</td>

</tr>

<tr> <td><b>u</b></td> <td>Undo the last action.</td> <td>Command</td>

</tr>

<tr> <td><b>o</b></td> <td>Open a new line above the current line.</td>
<td>Command</td>

</tr>

<tr> <td><b>Ctrl+g</b></td> <td>Display file name, total number of lines in
the file and the cursor position.</td> <td>Command</td>

</tr>

<tr> <td><b>/</b><i>term</i></td> <td>Search forward for all instances of a
term. Press n to go to the next term and N to go to the previous term.</td>
<td>Command</td>

</tr>

<tr> <td><b>?</b><i>term</i></td> <td>Search backward for all instances of a
term.  Press n to go to the previous term and N to go to the next term.</td>
<td>Command</td>

</tr>

<tr> <td><b>yy</b></td> <td>Copy a line of text into memory.</td>
<td>Command</td>

</tr>

<tr> <td><b>a</b></td> <td>Append text after the cursor</td> <td>Command</td>

</tr>

<tr> <td><b>A</b></td> <td>Append text after the current line</td>
<td>Command</td>

</tr>

<tr> <td><b>C</b></td> <td>Change text from current cursor position to the end
of the line.</td> <td>Command</td>

</tr>

<tr> <td><b>cc</b></td> <td>Change text of the entire line.</td>
<td>Command</td>

</tr>

<tr> <td><b>ZZ</b></td> <td>Save current file and exit vim.</td>
<td>Command</td>

</tr>

<tr> <td><b>h</b></td> <td>Move the cursor one space to the left.</td>
<td>Command</td>

</tr>

<tr> <td><b>j</b></td> <td>Move the cursor down a line.</td> <td>Command</td>

</tr>

<tr> <td><b>k</b></td> <td>Move the cursor up a line.</td> <td>Command</td>

</tr>

<tr> <td><b>l</b></td> <td>Move the cursor one space to the right.</td>
<td>Command</td>

</tr>

<tr> <td><b>z</b></td> <td>Exit without saving</td> <td>Command</td>

</tr>

<tr> <td> <b>:</b></td> <td>Enter command line mode from command mode</td>
<td>Command </td>

</tr>

<tr> <td><b>w</b> </td> <td>Save the current document.</td> <td>Command
line</td>

</tr>

<tr> <td><b>w</b> <i>filename</i></td> <td>Name and save the file.</td>
<td>Command line</td>

</tr>

<tr> <td><b>w!</b> <i>filename</i></td> <td>Overwrite the file</td>
<td>Command line</td>

</tr>

<tr> <td><b>q</b> </td> <td>Exit vim. This produces an error if the text was
modified.</td> <td>Command line</td>

</tr>

<tr> <td><b>q! </b></td> <td>Exit vim without saving.</td> <td>Command
line</td>

</tr>

<tr> <td><b>wq</b> or <b>exit</b></td> <td>Save the document and exit
vim.</td> <td>Command line</td>

</tr>

<tr> <td><b>e!</b></td> <td>Reload the file from the last saved version. This
discards all edits and reloads the last saved version of the file into
vim.</td> <td>Command line</td>

</tr> </table>

