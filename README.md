# Twu.Bucketlist

**Project Final Report**

Noah Solorzano
Jonathan Ninan

Device: Emulated Pixel 2

App Title: BucketList

The App is a tool used to keep track of tasks one wishes to complete, in other words,
a Bucket List. The app starts up with a prepopulated list as an example. You can click
on each item to open a different screen in which you can edit the name and description
of each task. There is a buton on the bottom right corner of the app that allows one to
add a new item to the list. Each item has a checkbox that marks an item as completed and
(should) move the item to the bottom of the list.

The app was made to be compatible for Nougat 7.0.

As evidenced by our multiple applications, we learned (by failure) that simple 
implementations were not going to suffice. We learned to differentiate between the
different types of layouts and their specific properties inside of the .xml 
document; RelativeLayout and CoordinatedLayout were personal favorites.
Recycler view vs cardview, listview and gridview indirectly learned of despite
the assignment requiring us to use recyclerview specifically. How to use an adapter
for recycler view as a required sub class. The optimization of memory usage that
comes with using recyclerview vs the other types. How to call by R.id inbetween files. How to use both the 
Design and Text tabs for ease as sometimes it was easier to add an element by
text rather than using the GUI tools; however, the GUI proved very useful when 
we didn't know proper syntax of the .xml documents. We learned the use of images
into our app through the drawable folder. The existence and utilization of various
dependencies for our app inside of the gradle. The importance of interdependencies 
throughout the code and the importance of maintaining it clean and organized. We learned
how hard it is to develop an App in 2 weeks with no book, limited and unspecific random 
tutorials and minimal guidance. 

**First Milestone**
First android app -  7.0 Nougat

The milestone upload of our app pulls up a [Bucket] List of items 
upon boot, pre-populated along with the floating button [Requirement 1 and 2.]
You have the ability to expand each item and view its full description [Req. 3.]
The app has custom images as icons for aesthetics :) and from 3 device tests
did not crash or lag. [Req. 4]