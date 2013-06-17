
ZoneLayout integration
----------------------

Plugin page: [http://artifacts.griffon-framework.org/plugin/zonelayout](http://artifacts.griffon-framework.org/plugin/zonelayout)


Provides integration with [ZoneLayout][1].

Usage
-----

The following nodes will become available on a View script upon installing this plugin

| *Node*     | *Type*                                      | *Property* | *Type* | *Notes*        |
| ---------- | ------------------------------------------- | ---------- | ------ | -------------- |
| zoneLayout | `com.atticlabs.zonelayout.swing.ZoneLayout` |            |        |                |
| zoneRow    |                                             | row        | String | row definition |
|            |                                             | template   | String | template name  |

The plugin includes a copy of the ZoneLayout cheatsheet in PDF format and the ZoneLayout manual in HTML format, located
in `$pluginHome/docs` once installed.

### Example

The following example is taken from Zonelayout's [comparison between FormLayout, GridBagLayout and itself][2]. It shows
how the layout can be used to define rows and templates.

    panel(constraints: CENTER) {
        zoneLayout {
            zoneRow('a-~a')
            zoneRow('b+*b')
        }
        panel(constraints: 'a', border: compoundBorder(outer: emptyBorder(5), inner: titledBorder(title: 'Name'))) {
            zl = zoneLayout {
                zoneRow('a>a2b-~b3c>c2d-~d', template: 'valueRow')
                zoneRow('6................', template: 'valueRow')
                zoneRow('e>e2f......-~...f')
            }
            zl.insertTemplate('valueRow');
            label 'First Name:', constraints: 'a'
            textField columns: 15, constraints: 'b'
            label 'Last Name:', constraints: 'c'
            textField columns: 15, constraints: 'd'
 
            zl.insertTemplate('valueRow');
            label 'Title:', constraints: 'a'
            textField columns: 15, constraints: 'b'
            label 'Nickname:', constraints: 'c'
            textField columns: 15, constraints: 'd'
 
            label 'Display Format', constraints: 'e'
            comboBox items: (1..5).collect([]){ i -> "Item $i"}, constraints: 'f'
        }
        panel(constraints: 'b', border: compoundBorder(outer: emptyBorder(5), inner: titledBorder(title: 'E-mail'))) {
            zoneLayout {
                zoneRow('a>a2b-~b2c-c')
                zoneRow('...........6')
                zoneRow('g........d-d')
                zoneRow('...........6')
                zoneRow('...+*....e-e')
                zoneRow('...........6')
                zoneRow('.........f-f')
                zoneRow('.......g...!')
            }
            label 'Email Address:', constraints: 'a'
            textField columns: 15, constraints: 'b'
            button 'Add', constraints: 'c'
            button 'Edit', constraints: 'd'
            button 'Remove', constraints: 'e'
            button 'Advanced', constraints: 'f'
            list items: (1..5).collect([]){ i -> "Item $i"}, constraints: 'g'
        }
    }

[1]: http://zonelayout.com
[2]: http://www.zonelayout.com/comparison.php

