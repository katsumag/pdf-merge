import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

fun Modifier.roundedBorder(thickness: Dp, colour: Color): Modifier {
    return border(thickness, colour, RoundedCornerShape(2.dp()))
}