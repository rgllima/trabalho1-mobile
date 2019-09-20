package br.ufc.quixada.basiccomponents.views

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import br.ufc.quixada.basiccomponents.R
import br.ufc.quixada.basiccomponents.adapters.PageViewAdapter
import br.ufc.quixada.basiccomponents.fragments.StickyNotesFragment
import br.ufc.quixada.basiccomponents.fragments.TaskListFragment
import br.ufc.quixada.basiccomponents.models.PageViewItem

class HomeActivity : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val myView = inflater.inflate(R.layout.activity_home, container, false)

        val pageViewArrayList: ArrayList<PageViewItem> = ArrayList()

        pageViewArrayList.add(PageViewItem(TaskListFragment(), "Tasks"))
        pageViewArrayList.add(PageViewItem(StickyNotesFragment(), "Sticky Notes"))

        val viewPager: ViewPager = myView.findViewById(R.id.pagerView)

        val frManager = this.childFragmentManager

        viewPager.apply {
            adapter = PageViewAdapter(frManager, pageViewArrayList)
        }

        return myView
    }
}
