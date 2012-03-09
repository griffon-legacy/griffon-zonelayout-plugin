/*
 * Copyright 2010-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the 'License');
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an 'AS IS' BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Andres Almiray
 */
class ZonelayoutGriffonPlugin {
    // the plugin version
    String version = '0.3'
    // the version or versions of Griffon the plugin is designed for
    String griffonVersion = '0.9.5 > *'
    // the other plugins this plugin depends on
    Map dependsOn = [swing: '0.9.5']
    // resources that are included in plugin packaging
    List pluginIncludes = []
    // the plugin license
    String license = 'Apache Software License 2.0'
    // Toolkit compatibility. No value means compatible with all
    // Valid values are: swing, javafx, swt, pivot, gtk
    List toolkits = ['swing']
    // Platform compatibility. No value means compatible with all
    // Valid values are:
    // linux, linux64, windows, windows64, macosx, macosx64, solaris
    List platforms = []
    // URL where documentation can be found
    String documentation = ''
    // URL where source can be found
    String source = 'https://github.com/griffon/griffon-zonelayout-plugin'

    List authors = [
        [
            name: 'Andres Almiray',
            email: 'aalmiray@yahoo.com'
        ]
    ]
    String title = 'ZoneLayout integration'
    String description = '''
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
'''
}
