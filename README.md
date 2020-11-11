# I Have No Idea What I'm Doing... :)
please help me

## the idea:
The goal is to have an xml-based language to create ui layouts, where the framework can be read by multiple languages. It should run at near-native speeds, and be not only cross-platform, but cross-language.

## what it is right now:
this repo holds the work-in-progress java interpreter.
### current features:
- read xml and convert into java layout, with jpanels acting as containers.
- change the layout between a wide variety (FlowLayout or GridLayout)

### (some of the) steps to completion:
- better layouts with json stylesheets, using SpringLayout to create custom arrangements
- something (maybe a hashmap) to hold variables that store the content of the page.

### more on that last one:
this framework is going to separate the content from the layout xml. When it is completed, the info between the tags is going to be the name of the 'variable' storing the content, which can be changed by the java (or other languages, once implemented) code. For static text, a 'content.json' file will be used, that holds the starting state of any of the content variables.

## please help out :) - current specifications:
### supported tags:
- \<button>{button label}\</button>
- \<label>{label text}\</label>
- \<panel {layout="grid" rows="{gridrow#}" cols="{gridcol#}"}>{panel contents}\</panel>
- (I know, so complex)
  
these specifications will be very different before completion.

