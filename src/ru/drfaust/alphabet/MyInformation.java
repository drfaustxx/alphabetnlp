/**
 * Говнокоооод
 */
package ru.drfaust.alphabet;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class MyInformation extends Activity {
     String message =
     "<h2>NLP New Code Alphabet Game</h2>"

    + "based on the game developed by John Grinder and Roger Tabb.<br/><br/>"
    + "The Alphabet Game was formulated by John Grinder (co-creater of the field of NLP) and Roger Tabb as one of the NLP New Code games. New Code NLP distinguishes itself from the classic code of NLP in that it includes formal engagement of the unconscious mental processes in its formulation.<br/><br/>"
    + "New Code NLP uses games and activities in order to elicit content free high performance states (\"know nothing states\") in the participants. As such they are optimal when used in a coaching or training environment where a skilled facilitator can calibrate the participants and faciliate the application of the know nothing state to any context where someone wants to enhance their performance.<br/><br/>"
    + "However, in the opinion of the creator of this little programme, the games are themselves powerfully challenging and elicit high performance states in their own right, and as such have value as stand alone activities. The Alphabet game would appear to simultaneously activate different areas of the brain and could be regarded as similar to juggling three coloured balls while having to name the one at the top of its arc each throw :-)<br/><br/>"

    + "<h2>Instructions</h2>"
    + "The game itself is really quite simple. The letters of the alphabet will each be associated with the letter L, R, or T below it. As each letter appears on the screen, you call out the letter above while performing the activity associated with the letter below, as follows<br/><br/>"
    + "L=raise then lower left hand<br/>"
    + "R=raise then lower right hand<br/>"
    + "T=raise then lower both hands<br/>";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);
        TextView txtInfo = (TextView)findViewById(R.id.txtInfo);
        txtInfo.setText(Html.fromHtml(message));
    }
}
