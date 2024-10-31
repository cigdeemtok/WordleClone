# WordleClone

This project is an Android Kotlin app, that is similar to Wordle Game. We used Kotlin, Firebase, Navigation. Me and my classmate [@meryemertrk](https://github.com/meryemertrk) made this project for a class homework. This project is word based game. Users can login and register with help of Firebase. There are different game styles that we called rooms. In each room, there are different number of letters that you can choose, that way you can select the word you are going to guess. Also there is something that is called letter constant in room types. If you choose this room, after you type the word that player is going to guess, app assigns a random letter from that word in game screen. So if you chose a 6 lettered room with letter constant, and let's say you entered the word "pencil". After you entered the game screen app assigns a random constant letter, like "n". So you will see this        "_ _ n _ _ _" in screen. 

Game is designed like this: 
* Player has right to guess as much as letter number.
* When you type a word, if you guess any letter right, the letter is going to turn green. If you type a letter that is in word but in a wrong place, letter is going to turn yellow. If you type a wrong letter, it is going to turn red. 
* After all guessing rights of player ends, that means player loses and it is displayed on screen with a Toast message.
* If you can guess the word before game ends or at your last guess chance, again all input areas are going to be disabled and app will show a Toast message to user.
* After game ends, you can always go back and try it again with different game styles.

App has login, register, room, active users and game screens. We used Navigation library to navigate between screens and passing arguments between screens. All data like user information, room information is saved to Firebase RealTimeDatabase. When you open the app, you will see login screen, if you have a account you can login. If you don't you should register and go back to login screen. After that, you will see all rooms with different numbered letters and with or without a letter constant. You can choose any room by clicking on it. Then app will take you to active users screen. You can see all logged in users. If you click on your username's button, you will go to guessed word screen. You can type the word and start playing by going to the game screen.

There are some images from the app:
* Login screen
<img src="https://github.com/cigdeemtok/WordleClone/blob/main/images/login.jpg" width="75%" />
  <br>
* Register screen
<img src="https://github.com/cigdeemtok/WordleClone/blob/main/images/register.jpg" width="75%" />
  <br>
* Room screen
<img src="https://github.com/cigdeemtok/WordleClone/blob/main/images/rooms.jpg" width="75%" />
  <br>
* Active users screen
<img src="https://github.com/cigdeemtok/WordleClone/blob/main/images/active_users.jpg" width="75%" />
  <br>
* Guess screen
<img src="https://github.com/cigdeemtok/WordleClone/blob/main/images/guess_screen.jpg" width="75%" />
  <br>
* Game screen with a letter constant
<img src="https://github.com/cigdeemtok/WordleClone/blob/main/images/letter_constant.jpg" width="75%" />
  <br>
* Gameplay screenshot
<img src="https://github.com/cigdeemtok/WordleClone/blob/main/images/game_screen.jpg" width="75%" />
  <br>

There are screenshots from database to show data structure:
* User data
<img src="https://github.com/cigdeemtok/WordleClone/blob/main/images/user_db.jpg" width="75%" />
  <br>
* Room data
<img src="https://github.com/cigdeemtok/WordleClone/blob/main/images/room_db.jpg" width="75%" />
  <br>

You can clone this repository and try it yourself. You should make sure you have all required libraries imported and make all connections for Firebase.

Any feedback is appreciated. I hope you find this project helpful.
