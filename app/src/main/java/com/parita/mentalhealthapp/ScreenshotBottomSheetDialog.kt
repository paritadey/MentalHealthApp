package com.parita.mentalhealthapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ScreenshotBottomSheetDialog : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val okay = view.findViewById<TextView>(R.id.okay_text)
        val cancel = view.findViewById<TextView>(R.id.cancel_text)
        okay?.setOnClickListener {
            dismiss()
            Toast.makeText(requireContext(), "Okay button is clicked", Toast.LENGTH_SHORT).show()
        }
        cancel?.setOnClickListener {
            dismiss()
            Toast.makeText(requireContext(), "Cancel button is clicked", Toast.LENGTH_SHORT).show()
        }
    }
}
