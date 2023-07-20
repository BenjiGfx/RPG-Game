### ReadMe zu meinem Abschlussprojekt von Modul 2

# Mini - LoL

#### In diesem Konsolen RPG wird ein Kampf zwischen 3 Helden und einem Gegner rundenbasiert simuliert.
#### Es kämpfen Teemo, Ashe und Lux gegen Baron Nashor. Jeder Charakter hat verschiedene Skills, mit denen der Kampf geführt wird.
#### Die Namen und Attacken der Charaktere basieren auf dem Spiel League of Legends, welches auch meine Inspiration für die Idee des RPG-Game war.
## Wie wird das Spiel gespielt?


##### Sie starten das Spiel, indem sie die Main.kt mit "Run" aktivieren.
##### Zuerst werden die jeweiligen Helden und der Gegner aufgelistet, damit der Spieler einen kleinen überblick bekommt.
##### Anschließend kann der Spieler den Helden wählen, mit dem er zuerst angreifen will und kann dann entweder eine Attacke auswählen oder einen Trank aus dem inventar anwenden. Die Helden werden der Reihe nach ausgewählt und jeder Gegner kann pro Runde nur eine Aktion ausführen.
##### Sobald alle Helden eine Aktion durchgeführt haben, greift der Gegner mit einer zufälligen Attacke aus seinen Skills an, welche entweder einen Helden direkt treffen können oder einen Flächenschaden bewirken, welcher allen Helden den gleichen den gleichen Schaden zufügt. Der Gegner kann außerdem einmal in Spiel einen Vasallen beschwören, welcher ebenfalls von den Helden besiegt werden muss.
##### Dieser Ablauf wiederholt sich, bis entweder alle Helden besiegt wurden oder der Gegner keine Lebenspunkte mehr aufweisen kann.
##### Sind alle Helden besiegt ist, das Spiel vorbei und der Spieler hat verloren. Wurde der Gegner besiegt, gewinnt der Spieler das Spiel.

## Im Spiel werden folgende Funktionen benutzt:

##### Mit der Funktion "attackieren()" in der Klasse "Held" wird der Gegner von den Helden aus attackiert. Der Schaden, der jeweilige Attacke kann durch ein Vitamin aus dem Beutel um 10% erhöht werden.
##### In der Klasse Gegner befindet sich ebenfalls eine Funktion "attackieren()", mit welcher der Gegner die Helden angreift, ob mit direktem Schaden oder Flächenschaden.
##### Mit der Funktion "getRandomHeld", greift der Gegner einen zufälligen Helden an.
##### Zu guter Letzt wird nach jeder Attacke mit der Funktion "wasted()" überprüft, ob die Charaktere noch Lebenspunkte haben oder nicht.

## Welche Klassen habe ich erstellt für das Spiel?
##### Held, Team, Ashe, Lux, Teemo, Gegner, Skill, Item
