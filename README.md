# CustomGridViewFixedNoOfImages

###What this project do :: 

    This Project shows how to create dynamic views in android with automated fixed number of images per row
    
========================

### PortraitMode View
![CustomGridViewFixedNoOfImages-Portrait](https://github.com/devrath/CustomGridViewFixedNoOfImages/blob/master/snapshot_portrait.gif)          

========================

### LandscapeMode View
![CustomGridViewFixedNoOfImages-Landscape](https://github.com/devrath/CustomGridViewFixedNoOfImages/blob/master/snapshot_landscape.gif)

========================


### ALGORITHM

    Calculation for autofit gridview(Imagesize will be determined based on the screen size and orientation)
    Fixing the no of column for portrait 2 and landscape 3
    Note:Here the padding will be 5dpi between each column,also no of column for portrait is fixed 2 and landscape is 3
	
-----
    Let us take 240*320-(ldpi)
	No of columns for autofit gridview
	screen width 320
	No of column in portrait mode is 2
	therefore total no of image can be displayed is 2

-----
	width calculation for autofit gridview
	(screen_width-outer_padding-(image_padding*maxPortCol))/maxPortCol
	320-10=310-(10*2)=(int)floor(290/2)=180
	
-----
	Height calcualtion for autofit gridview ratio is 10:7 for the ratio if image width is 100 then height must be 70
	imagewidth/ratio
	10/7=1.4285
	180/1.4285=(int)floor(126.315)=126






---

## Project Observations

* Android has a widget called `gridView`, what this widget does is it scrolls a collection of images `vertically` but most of the times we need to do more than that.

* `Listview` comes with a built-in `header` and `footer` and we can add them by adding few lines of code but same thing cannot be done for a `gridview`.

* In this project we are adding a `header` and `footer` to a `gridview`

* This project id developed so that user can add `row-wise` widgets for example, we can add a `sub-header` and a `collection of views` again a new `sub-header` further collection of views.

* These customizations help in creating `categorized gridView`  

---


## Usage

* Download the project from the `GitHub` or the `DropBox` links 
* Demo already has the `Jar` but if you are making a new project make sure you download the `Jar` from teh Link and add it to the `libs` folder in your project
* And that is it !




## App Specifications

* Minimum Sdk = 14
* Compiled with = 19
* Tested in android emulator

### Download from DropBox
[![Download from DropBox](https://dt8kf6553cww8.cloudfront.net/static/images/icons/blue_dropbox_glyph-vflJ8-C5d.png)](https://www.dropbox.com/s/mh688796ch5y35h/CustomGridViewFixedNoOfImages.rar)

### Download Jar
[![Download from DropBox](https://github.com/devrath/CustomGridViewFixedNoOfImages/blob/master/jarImage.png)](https://www.dropbox.com/s/387ce7bh3aa8u2y/GridViewHeader.jar)




License
=======

    Copyright 2014 Devrath
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

