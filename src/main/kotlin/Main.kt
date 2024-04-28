import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.onClick
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.ComposeWindow
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import theme.AppTheme
import java.io.File

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun App(window: ComposeWindow) {
    val text by remember { mutableStateOf("Hello, World!") }
    var showFileDialog by remember { mutableStateOf(false) }
    val selectedPDFFiles by remember { mutableStateOf(mutableSetOf<File>()) }


    Row {
        Column(Modifier
            .padding(16.dp())
            .fillMaxWidth(0.5f)
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.surfaceContainer)
            .shadow(1.dp())
            .onClick {
                println("Column 1")
            }
        ) {
            Text(text)
        }

        Column(Modifier
            .padding(16.dp())
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceContainer)
            .shadow(1.dp())
            .onClick {
                println("Column 2")
                showFileDialog = true
            }
        ) {
            Text("Imported PDF Files:")

            selectedPDFFiles.forEach {
                Row(Modifier
                    .padding(8.dp())
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surfaceContainerLowest)
                ) {
                    Text(it.name)
                    Text(it.path)
                    Text(it.extension)
                }
            }
        }
    }

    if (showFileDialog) {
        val openedFiles = openFileDialog(window, "Test", listOf("pdf")) {
            showFileDialog = false
        }

        selectedPDFFiles.addAll(openedFiles)
    }
}



fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        AppTheme {
            Surface {
                App(this.window)
            }
        }
    }
}

fun Int.dp() = Dp(this.toFloat())