package br.ufc.quixada.basiccomponents.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import br.ufc.quixada.basiccomponents.models.PageViewItem

class PageViewAdapter (fm: FragmentManager, private val pageViewArray: ArrayList<PageViewItem>): FragmentPagerAdapter(fm) {

    override fun getCount(): Int = pageViewArray.size

    override fun getItem(position: Int): Fragment {
        return pageViewArray[position].viewFragment
    }

    override fun getPageTitle(position: Int): CharSequence {
        return pageViewArray[position].title
    }
}