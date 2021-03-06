package xue.myapp.module.demo.ui;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.File;

import xue.myapp.R;
import xue.myapp.common.ui.CommonActivity;

/**
 * 详情页
 */
public class InfoActivity extends CommonActivity {


    @Override
    protected void initUI() {
        initView();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int setLayout() {
        return R.layout.activity_info;
    }

    public void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(NavigationActivity.class);
              /*  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                requestRuntimepermission(new String[]{Manifest.permission.CALL_PHONE,
                                        Manifest.permission.ACCESS_FINE_LOCATION,
                                        Manifest.permission.CAMERA

                                }, new PermissionLintener() {
                                    @Override
                                    public void onGranted() {
                                        Toast.makeText(MainActivity.this, "同意权限", Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onDenied(List<String> deniedPermisson) {
                                        for (String s : deniedPermisson) {
                                            Toast.makeText(InfoActivity.this, s+"权限被拒绝", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
                        }).show();*/
            }
        });
    }

    //不显示父类的ToolBar
    @Override
    protected boolean isShowToolBar() {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //存文件时，把缓存文件存在自己APP安装包之下
    private void saveFile(){
       File file =getExternalCacheDir();  //此方法的弊端就是存的文件容易被清理软件清理掉
        file.getPath();
        //此方法是存文件保存在自己APP安装包自己定义的目录下清理软件清理不掉，参数相当于文件名，为空的话默认的文件名为Files
        getExternalFilesDir("myFileCatch");
    }
}
