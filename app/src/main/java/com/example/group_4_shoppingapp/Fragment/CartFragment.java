package com.example.group_4_shoppingapp.Fragment;


import androidx.fragment.app.Fragment;

public class CartFragment extends Fragment  {
/*
    private static FrameLayout noItemDefault;
    private static RecyclerView recyclerView;
    private ItemTouchHelper mItemTouchHelper;
    public CartFragment() {
    }


    public static void updateMyCartFragment(boolean showList) {

        if (showList) {

            if (null != recyclerView && null != noItemDefault) {
                recyclerView.setVisibility(View.VISIBLE);

                noItemDefault.setVisibility(View.GONE);
            }
        } else {
            if (null != recyclerView && null != noItemDefault) {
                recyclerView.setVisibility(View.GONE);

                noItemDefault.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_product_list_fragment, container,
                false);

        view.findViewById(R.id.slide_down).setVisibility(View.VISIBLE);
        view.findViewById(R.id.slide_down).setOnTouchListener(
                new View.OnTouchListener() {

                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        Utils.switchFragmentWithAnimation(R.id.frag_container,
                                new HomeFragment(),
                                ((ECartHomeActivity) (getContext())),
                                Utils.HOME_FRAGMENT, AnimationType.SLIDE_DOWN);

                        return false;
                    }
                });

        // Fill Recycler View

        noItemDefault = (FrameLayout) view.findViewById(R.id.default_nodata);

        recyclerView = (RecyclerView) view
                .findViewById(R.id.product_list_recycler_view);

        if (CenterRepository.getCenterRepository().getListOfProductsInShoppingList().size() != 0) {

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                    getActivity().getBaseContext());

            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setHasFixedSize(true);

            ShoppingListAdapter shoppinListAdapter = new ShoppingListAdapter(
                    getActivity(), this);

            recyclerView.setAdapter(shoppinListAdapter);

            shoppinListAdapter
                    .SetOnItemClickListener(new AdapterView.OnItemClickListener() {

                        @Override
                        public void onItemClick(View view, int position) {

                            Utils.switchFragmentWithAnimation(
                                    R.id.frag_container,
                                    new ProductDetailsFragment("", position,
                                            true),
                                    ((ECartHomeActivity) (getContext())), null,
                                    AnimationType.SLIDE_LEFT);

                        }
                    });

            ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(
                    shoppinListAdapter);
            mItemTouchHelper = new ItemTouchHelper(callback);
            mItemTouchHelper.attachToRecyclerView(recyclerView);

        } else {

            updateMyCartFragment(false);

        }

        view.findViewById(R.id.start_shopping).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Utils.switchContent(R.id.frag_container,
                                Utils.HOME_FRAGMENT,
                                ((ECartHomeActivity) (getContext())),
                                AnimationType.SLIDE_UP);

                    }
                });

        // Handle Back press
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP
                        && keyCode == KeyEvent.KEYCODE_BACK) {

                 //   Utils.switchContent(R.id.frag_container,
                   //         Utils.HOME_FRAGMENT,
                     //       ((ECartHomeActivity) (getContext())),
                       //     AnimationType.SLIDE_UP);

                }
                return true;
            }
        });

        return view;
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }*/

}