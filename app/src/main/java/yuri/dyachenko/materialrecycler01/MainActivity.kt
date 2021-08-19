package yuri.dyachenko.materialrecycler01

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import yuri.dyachenko.materialrecycler01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val adapter = NotesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            notesRecyclerView.addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    LinearLayoutManager.VERTICAL
                )
            )
            notesRecyclerView.adapter = adapter
        }

        adapter.setNotes(NoteGenerator.getDefValues())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (doAction(item.itemId)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun doAction(id: Int): Boolean {
        when (id) {
            R.id.notes_edit_action -> {
                adapter.editNote()
                return true
            }
        }
        return false
    }
}