package com.dl7.taglayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dl7.tag.TagLayout;
import com.dl7.tag.TagView;
import com.dl7.taglayout.utils.TagWordFactory;
import com.dl7.taglayout.utils.ToastUtils;

public class TagChoiceActivity extends AppCompatActivity implements TagView.OnTagClickListener, TagView.OnTagLongClickListener {

    private TagLayout mTagLayout1;
    private TagLayout mTagLayout2;
    private TagLayout mTagLayout3;
    private TagLayout tag_layout;
    private TagView mTagDel;
    private TagView mTagAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag_choice);
        initView();
    }

    private void initView() {
        mTagLayout1 = (TagLayout) findViewById(R.id.tag_layout_1);
        mTagLayout2 = (TagLayout) findViewById(R.id.tag_layout_2);
        mTagLayout3 = (TagLayout) findViewById(R.id.tag_layout_3);
        tag_layout = (TagLayout)findViewById(R.id.tag_layout);
        mTagDel = (TagView) findViewById(R.id.tag_del);
        mTagAdd = (TagView) findViewById(R.id.tag_add);
        mTagLayout1.setTagClickListener(this);
        mTagLayout1.setTagLongClickListener(this);
        mTagLayout2.setTagClickListener(this);
        mTagLayout2.setTagLongClickListener(this);
        mTagLayout3.setTagClickListener(this);
        mTagLayout3.setTagLongClickListener(this);

        tag_layout.setTagClickListener(this);

        mTagAdd.setTagClickListener(new TagView.OnTagClickListener() {
            @Override
            public void onTagClick(int position, String text, @TagView.TagMode int tagMode) {
                String word = TagWordFactory.provideTagWord();
                mTagLayout1.addTag(word);
                mTagLayout2.addTag(word);
                mTagLayout3.addTag(word);
            }
        });
        mTagLayout1.addTag("ddd");
        mTagLayout1.addTag("rew");
        mTagLayout1.addTag("记得发");
        mTagLayout1.setCheckTag(1);

        mTagLayout3.addTag("￣□￣｜｜");
        mTagLayout3.setCheckTag(0);

        mTagLayout2.addTag("sfd");
        mTagLayout2.addTag("gfd");
        mTagLayout2.setCheckTag(0,1);

        mTagLayout2.addTag("rrrr");
        mTagLayout2.setCheckTag(0,1,2);

        mTagDel.setTagClickListener(new TagView.OnTagClickListener() {
            @Override
            public void onTagClick(int position, String text, @TagView.TagMode int tagMode) {
                mTagLayout1.deleteCheckedTags();
                mTagLayout2.deleteCheckedTags();
                mTagLayout3.deleteCheckedTags();
            }
        });
    }

    @Override
    public void onTagClick(int position, String text, @TagView.TagMode int tagMode) {
        ToastUtils.showToast(text);
    }

    @Override
    public void onTagLongClick(int position, String text, @TagView.TagMode int tagMode) {
        ToastUtils.showToast("长按:" + text);
    }
}
