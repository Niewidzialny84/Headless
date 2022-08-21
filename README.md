# Headless

### Description
Simple plugin for getting and dropping heads from mobs with configurable chances.

### Config
All values are shipped with the plugin and set to default value. 

```yaml
#Entity name that drops
PLAYER:
  #Should this entity drop a head; default: false
  drop: true
  #Chance in % to drop head; default 5
  chance: 15
  #Looting increase per each level e.g. Looting 1 adds 1% more chance resulting in 6% chance here.
  #Looting 3 adds 3% and will result in 8% chance to drop head
  #Formula is: chance + (looting  * looting enchantment)
  #default 0
  looting: 1
```