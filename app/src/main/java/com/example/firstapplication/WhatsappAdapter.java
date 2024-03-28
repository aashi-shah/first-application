package com.example.firstapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class WhatsappAdapter extends FragmentStatePagerAdapter {
    int tabCount;
    public WhatsappAdapter(FragmentManager supportFragmentManager, int tabCount) {
        super(supportFragmentManager);

        this.tabCount = tabCount;
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                ChatsFragment chatsFragment = new ChatsFragment();
                return chatsFragment;

            case 1:
                StatusFragment statusFragment = new StatusFragment();
                return statusFragment;

            case 2:
                CallsFragment callsFragment = new CallsFragment();
                return callsFragment;
        }
        return null;
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return tabCount;
    }
}
