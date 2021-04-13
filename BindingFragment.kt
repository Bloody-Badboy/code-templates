#if (${PACKAGE_NAME} != "")package ${PACKAGE_NAME}#end

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class ${NAME} : Fragment() {

    private var _binding: ${Binding}? = null
    protected val binding: ${Binding}
        get() = checkNotNull(_binding) {
            "Fragment \$this binding cannot be accessed before onCreateView() or after onDestroyView()"
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.${LayoutResId}, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
