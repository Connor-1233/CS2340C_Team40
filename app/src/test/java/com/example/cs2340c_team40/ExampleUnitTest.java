package com.example.cs2340c_team40;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.cs2340c_team40.Model.Leaderboard;
import com.example.cs2340c_team40.Model.MoveHorizontal;
import com.example.cs2340c_team40.Model.MoveVertical;
import com.example.cs2340c_team40.Model.Player;
import com.example.cs2340c_team40.View.ConfigScreen;
import com.example.cs2340c_team40.ViewModel.ConfigScreenViewModel;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

        @Test
        public void testLeaderboardInitialization() {
            Leaderboard leaderboard = Leaderboard.getInstance();
            leaderboard.resetLeaderboard();
            assertEquals(leaderboard.getSize(), 0);
        }

        @Test
        public void testAddScoreToLeaderboard() {
            Leaderboard lb = Leaderboard.getInstance();
            lb.resetLeaderboard();
            lb.updateScore(100, "Player1");
            lb.updateScore(150, "Player2");
            lb.updateScore(75, "Player3");
            assertEquals(3, lb.getSize());
        }
        @Test
        public void testNameValidator_NullName() {
            String name = null;
            assertFalse(ConfigScreenViewModel.isValidName(name));
        }

        @Test
        public void testNameValidator_EmptyName() {
            String name = "";
            assertFalse(ConfigScreenViewModel.isValidName(name));
        }

        @Test
        public void testNameValidator_WhitespaceName() {
            String name = "    ";
            assertFalse(ConfigScreenViewModel.isValidName(name));
        }



        @Test
        public void testNameValidator_ValidName() {
            String name = "John Doe";
            assertTrue(ConfigScreenViewModel.isValidName(name));
        }

        @Test
        public void testMoveHorizontal() {
            Player player = Player.getInstance();
            player.setX(5);
            new MoveHorizontal(1).movePlayer();
            assertEquals(player.getX(), 10);
        }

        @Test
        public void testMoveVertical() {
            Player player = Player.getInstance();
            player.setY(5);
            new MoveVertical(1).movePlayer();
            assertEquals(player.getY(), 10);
        }

}